package level2;

import java.util.Arrays;

public class TriangleSnail {
    
    public static void main(String[] args) {
        int n = 6;

        int[] actual = solution(n);

        int[] expected = {1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int n) {
        int length = n * (n + 1) / 2;
        int[] answer = new int[length];
        int[][] matrix = new int[n][n];
        
        int num = 1;
        int x = -1;
        int y = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                
                matrix[x][y] = num++;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) break;
                
                answer[idx++] = matrix[i][j];
            }
        }
        
        return answer;
    }
}
