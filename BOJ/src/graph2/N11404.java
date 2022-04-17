package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11404 {
	
	static final int INF = 10000000;
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (i != j) map[i][j] = INF;
			}
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = Math.min(map[a][b], c);
		}
		
		floydWarshall();
		
		showMap(map);
	}
	
	static void floydWarshall() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}
	
	static void showMap(int[][] map) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				if (map[i][j] >= INF) sb.append("0").append(" ");
				else sb.append(map[i][j]).append(" ");
			}
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
