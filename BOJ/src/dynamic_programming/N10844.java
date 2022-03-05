package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10844 {
	
	static final long mod = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10];
		
		for (int i = 1; i < 10; i++) {
			// 1자리 수의 i 번째 수가 계단이 되는 경우는 한가지 이므로 1로 초기화
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				
				// 끝자리가 0인 경우: 다음 올 수 있는 숫자는 1밖에 없다.
				if (j == 0) dp[i][j] = dp[i - 1][j + 1] % mod;
				
				// 끝자리가 9인 경우: 다음 올 수 있는 숫자는 8밖에 없다.
				else if (j == 9) dp[i][j] = dp[i - 1][j - 1] % mod;
				
				// 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합
				else dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % mod;
			}
		}
		
		long result = 0;
		for (int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % mod);
	}
}
