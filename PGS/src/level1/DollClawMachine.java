package level1;

import java.util.Stack;

public class DollClawMachine {
    
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int actual = solution(board, moves);

        int expected = 4;
        System.out.println(actual == expected);
    }

    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        for (int move : moves) {
            int n = getNumberOfBoard(move - 1, board);
            if (n == -1) {
                continue;
            }
            
            if (!stk.isEmpty() && stk.peek() == n) {
                stk.pop();
                answer += 2;
                continue;
            }
            
            stk.push(n);
        }
        
        return answer;
    }
    
    static int getNumberOfBoard(int n, int[][] board) {
        int answer = -1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][n] > 0) {
                answer = board[i][n];
                board[i][n] = 0;
                return answer;
            }
        }
        
        return answer;
    }
}
