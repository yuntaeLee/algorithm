package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = dp[0] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());	
			dp[i] = Math.max(value, dp[i - 1] + value);
			
			if (dp[i] > max) max = dp[i];
		}
		
		System.out.println(max);
	}
}
