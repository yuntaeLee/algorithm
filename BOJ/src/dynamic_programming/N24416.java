package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N24416 {
	
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n];
		
		sb.append(fibonacci(n)).append(' ').append(n - 2);
		System.out.println(sb);
	}
	
	static int fibonacci(int n) {
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		
		return dp[n - 1];
	}
}
