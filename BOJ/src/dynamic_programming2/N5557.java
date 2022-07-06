package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5557 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		long[][] dp = new long[N][21];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1][arr[1]] = 1;
		
		for (int i = 2; i < N; i++) {
			for (int j = 0; j <= 20; j++) {
				long prev = dp[i - 1][j];
				if (prev != 0) {
					if (j - arr[i] >= 0) {
						dp[i][j - arr[i]] += prev;
					}
					if (j + arr[i] <= 20) {
						dp[i][j + arr[i]] += prev;
					}
				}
			}
		}
		
		System.out.println(dp[N - 1][arr[N]]);
	}
}
