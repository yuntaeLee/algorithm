package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1010 {
	
	static long[][] dp = new long[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(c(M, N)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static long c(int n, int m) {
		
		if (dp[n][m] != 0) return dp[n][m];
		if (n == m || m == 0) return 1;
		
		// nCm = (n-1)C(m-1) + (n-1)C(m);
		else {
			dp[n][m] = c(n - 1, m - 1) + c(n - 1, m);
			return dp[n][m];
		}
	}
}
