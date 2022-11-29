package dynamic_programming2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2294 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
//		int[] coins = new int[n];
		
		boolean[] coins = new boolean[k + 1];
		int[] dp = new int[k + 1];
		
		for (int i = 0; i < n; i++) {
//			coins[i] = Integer.parseInt(br.readLine());
			int coin = Integer.parseInt(br.readLine());
			if (coin <= k) {
				coins[coin] = true;
			}
		}

		Arrays.fill(dp, 100001);
		dp[0] = 0;
		
		for (int i = 1; i <= k; i++) {
			if (coins[i]) {
				dp[i] = 1;
				
				for (int j = i + 1; j <= k; j++) {
					dp[j] = Math.min(dp[j], dp[j - i] + 1);
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = coins[i]; j <= k; j++) {
//				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//			}
//		}
		
		System.out.println(dp[k] == 100001 ? -1 : dp[k]);
	}
}
