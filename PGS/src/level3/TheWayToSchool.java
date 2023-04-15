package level3;

public class TheWayToSchool {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int result = 4;
        System.out.println(result == solution(m, n, puddles));
    }

    static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if (i != 0) {
                    dp[i][j] += dp[i - 1][j] % 1000000007;
                }
                
                if (j != 0) {
                    dp[i][j] += dp[i][j - 1] % 1000000007;   
                }
            }
        }
        
        return dp[n - 1][m - 1] % 1000000007;
    }
}
