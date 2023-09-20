package level0;

import java.util.Arrays;

public class Snail {

    public static void main(String[] args) {
        int n = 5;

        int[][] actual = solution(n);

        int[][] expected = {
            {1, 2, 3, 4, 5}, 
            {16, 17, 18, 19, 6}, 
            {15, 24, 25, 20, 7}, 
            {14, 23, 22, 21, 8}, 
            {13, 12, 11, 10, 9}};

        System.out.println(Arrays.equals(actual, expected, Arrays::compare));
    }
    
    static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        int x = 0;
        int y = 0;
        
        for (int i = 1; i <= n * n; i++) {
            answer[x][y] = i;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (outOfMap(nx, ny, n) || answer[nx][ny] > 0) {
                dir = (dir + 1) % 4;
            }
            
            x = x + dx[dir];
            y = y + dy[dir];
        }
        
        return answer;
    }
    
    static boolean outOfMap(int x, int y, int n) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
