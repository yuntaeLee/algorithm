package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14716 {
	
	static int ans;
	static int N, M;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (outOfArea(nx, ny)) continue;
			
			if (!visited[nx][ny] && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= M;
	}
}
