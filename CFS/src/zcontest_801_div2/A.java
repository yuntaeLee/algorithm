package zcontest_801_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	
	static int N, M;
	
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int max = Integer.MIN_VALUE;
			int a = 0;
			int b = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < M; j++) {
					int n = Integer.parseInt(st.nextToken());
					
					if (n > max) {
						max = n;
						a = i;
						b = j;
					}
				}
			}
			
			long ans = Math.max(a + 1, N - a) * Math.max(b + 1, M - b);
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
