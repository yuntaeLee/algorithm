package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2747 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[n + 1];
		
		System.out.println(fib(n, dp));
	}
	
	static long fib(int n, long[] dp) {
		if (dp[n] != 0) return dp[n];
		
		dp[n] = (n == 1 || n == 2) ? 1 : fib(n - 1, dp) + fib(n - 2, dp);
		
		return dp[n];
		
	}
}