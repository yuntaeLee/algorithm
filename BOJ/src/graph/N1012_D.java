package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1012_D {
	
	static int N, M;
	static int count;
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			graph = new int[N][M];
			visited = new boolean[N][M];
			count = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph[y][x] = 1;
			}
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (!visited[x][y] && graph[x][y] == 1) {
						dfs(x, y);
						count++;
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
				if (!visited[xx][yy] && graph[xx][yy] == 1) {
					dfs(xx, yy);
				}
			}
		}
	}
}
