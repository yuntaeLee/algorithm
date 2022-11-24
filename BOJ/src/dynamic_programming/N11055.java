package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11055 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = dp[0] = arr[0];
		for (int i = 1; i < n; i++) {
			dp[i] = arr[i];
			
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + arr[i], dp[i]);
				}
			}
			
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
