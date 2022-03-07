package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2193_2 {

	static int N;
	static Long[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new Long[N + 1];
		
		dp[0] = 0L;
		dp[1] = 1L;
		
		System.out.println(recur(N));
	}
	
	static long recur(int N) {
		
		if (dp[N] == null) {
			dp[N] = recur(N - 1) + recur(N - 2);
		}
		
		return dp[N];
	}
}
