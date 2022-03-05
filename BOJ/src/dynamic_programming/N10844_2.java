package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10844_2 {

	static final long mod = 1000000000;
	static int N;
	static Long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new Long[N + 1][10];
		
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1L;
		}
		
		long result = 0;
		for (int i = 1; i < 10; i++) {
			result += recur(N, i);
		}
		
		System.out.println(result % mod);
	}
	
	// dist = 자릿수, val = 자릿값
	static long recur(int dist, int val) {
		
		// 첫째 자리수에 도달하면 더이상 탐색할 필요 없음
		if (dist == 1) return dp[dist][val];
		
		if (dp[dist][val] == null) {
			
			if (val == 0) dp[dist][val] = recur(dist - 1, 1);
			
			else if (val == 9) dp[dist][val] = recur(dist - 1, 8);
			
			else dp[dist][val] = recur(dist - 1, val + 1) + recur(dist - 1, val - 1);
		}
		
		return dp[dist][val] % mod;
	}
	
	

}
