package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N12852 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] trace = new int[N + 1];
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			trace[i] = i - 1;
			
			if (i % 3 == 0) {
				if (dp[i] > dp[i / 3] + 1) {
					dp[i] = dp[i / 3] + 1;
					trace[i] = i / 3;
				}
			}
			
			if (i % 2 == 0) {
				if (dp[i] > dp[i / 2] + 1) {
					dp[i] = dp[i / 2] + 1;
					trace[i] = i / 2;
				}
			}	
		}
		
		sb.append(dp[N]).append('\n');
		
		while (N > 0) {
			sb.append(N).append(' ');
			N = trace[N];
		}
		
		System.out.println(sb);
	}

}
