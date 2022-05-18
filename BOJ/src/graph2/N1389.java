package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1389 {
	
	static final int INF = 987654321;
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i != j) map[i][j] = INF;
			}
		}
		
		int M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		floydWarshall();
		
		int min = Integer.MAX_VALUE;
		int idx = -1;
		
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			
			for (int j = 1; j <= N; j++) {
				sum += map[i][j];
			}
			
			if (min > sum) {
				min = sum;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
	
	static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
	}

}
