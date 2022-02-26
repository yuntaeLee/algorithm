package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2579 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		for (int n = 3; n <= N; n++) {
			dp[n] = Math.max(dp[n - 3] + arr[n - 1], dp[n - 2]) + arr[n];
		}
		
		System.out.println(dp[N]);
	}
}
