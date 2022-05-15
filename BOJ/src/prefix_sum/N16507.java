package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16507 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[][] prefixSum = new int[R + 1][C + 1];
		
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= C; j++) {
				if (j == 1) prefixSum[i][j] = Integer.parseInt(st.nextToken());
				else prefixSum[i][j] = Integer.parseInt(st.nextToken()) + prefixSum[i][j - 1];
			}
		}
		
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			sb.append(getAvgBirghtness(prefixSum, r1, c1, r2, c2)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int getAvgBirghtness(int[][] prefixSum, int r1, int c1, int r2, int c2) {
		int ans = 0;
		
		for (int i = r1; i <= r2; i++) {
			ans += prefixSum[i][c2] - prefixSum[i][c1 - 1];
		}
		
		return ans / ((r2 - r1 + 1) * (c2 - c1 + 1));
	}
}
