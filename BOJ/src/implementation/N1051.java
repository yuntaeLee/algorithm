package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1051 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(solution(board, N, M));
    }

    static int solution(int[][] board, int n, int m) {
        for (int len = Math.min(n, m) - 1; len > 0; len--) {
            for (int i = 0; i < n - len; i++) {
                for (int j = 0; j < m - len; j++) {
                    int num = board[i][j];
                    if (num == board[i][j + len] && num == board[i + len][j] && num == board[i + len][j + len]) {
                        return (int) Math.pow(len + 1, 2);
                    }
                }
            }
        }

        return 1;
    }
}
