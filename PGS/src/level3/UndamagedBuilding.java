package level3;

public class UndamagedBuilding {

    static int N, M;
    static int[][] prefixSum;
    
    public static void main(String[] args) {
        int[][] board = {
            {5,5,5,5,5}, 
            {5,5,5,5,5}, 
            {5,5,5,5,5}, 
            {5,5,5,5,5}};

        int[][] skill = {
            {1,0,0,3,4,4}, 
            {1,2,0,2,3,2}, 
            {2,1,0,3,1,2}, 
            {1,0,1,3,3,1}};

        int actual = solution(board, skill);

        int expected = 10;
        System.out.println(actual == expected);
    }

    static int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        prefixSum = new int[N + 1][M + 1];
        
        for (int[] arr : skill) {
            int r1 = arr[1], c1 = arr[2];
            int r2 = arr[3], c2 = arr[4];
            int degree = arr[0] == 1 ? -arr[5] : arr[5];
            
            prefixSum[r1][c1] += degree;
            prefixSum[r1][c2 + 1] -= degree;   
            prefixSum[r2 + 1][c1] -= degree;
            prefixSum[r2 + 1][c2 + 1] += degree;   
        }
        
        calculate();
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + prefixSum[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    static void calculate() {
        // 좌 -> 우
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                 prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        
        // 상 -> 하
        for (int j = 0; j < M; j++) {
            for (int i = 1; i < N; i++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }
    }
}
