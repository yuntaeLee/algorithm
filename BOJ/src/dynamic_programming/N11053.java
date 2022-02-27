package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11053 {
	
	static Integer[] dp;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N];
		seq = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			LIS(i);
		}
		
		int max = dp[0];
		for (int i = 1; i < N; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		
		System.out.println(max);
	}
	
	static int LIS(int N) {
		
		if (dp[N] == null) {
			dp[N] = 1;
			
			// N 이전의 노드들을 탐색
			for (int i = N - 1; i >= 0; i--) {
				
				// 이전 노드 중 seq[N]의 값보다 작을 경우
				if (seq[i] < seq[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		
		return dp[N];
	}
}
