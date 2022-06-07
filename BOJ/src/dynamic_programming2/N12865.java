package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12865 {
		
	static int[] w;
	static int[] v;
	
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		w = new int[N];
		v = new int[N];
		dp = new Integer[N][K + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(KS(N - 1, K));
	}
	
	static int KS (int n, int k) {
		if (n < 0) return 0;
		
		if (dp[n][k] == null) {
			
			// 현재 물건을 추가로 못 담는 경우 (이전 값 탐색)
			if (w[n] > k) dp[n][k] = KS(n - 1, k);
			
			else {
				// 이전 n값과 이전 n값에 대한 k-w[n]의 값 + 현재 가치(v[n]) 중 큰 값을 저장
				int tmp1 = KS(n - 1, k);
				int tmp2 = KS(n - 1, k - w[n]) + v[n];
				dp[n][k] = Math.max(tmp1 ,tmp2);
			}
		}
		
		return dp[n][k];
	}
}
