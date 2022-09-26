package floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1956 {
	
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] map = new int[V + 1][V + 1];
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i != j) map[i][j] = INF;
			}
		}
		
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = c;
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (i == j) continue;
					
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int ans = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) continue;
				
				if (map[i][j] != INF && map[j][i] != INF) {
					ans = Math.min(ans, map[i][j] + map[j][i]);
				}
			}
		}
		
		System.out.println(ans == INF ? -1 : ans);
	}
}
