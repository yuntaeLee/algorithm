package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2001 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[][] prefixSum = new int[N][N];
			int ans = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (j >= M - 1) {
						for (int k = j - M + 1; k <= j; k++) {
							prefixSum[i][j] += map[i][k];
						}
					}
					
					if (i >= M - 1) {
						int temp = 0;
						for (int k = i - M + 1; k <= i; k++) {
							temp += prefixSum[k][j];
						}
						
						ans = Math.max(ans, temp);
					}
				}
			}
						
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
