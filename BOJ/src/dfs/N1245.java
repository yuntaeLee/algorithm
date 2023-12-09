package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1245 {
	
	static int N, M;
	static boolean isPeak;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1};
	static int[] dy = {0, -1, 0, 1, -1, -1, 1, 1};
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

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

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					visited[i][j] = true;
					isPeak = true;
					dfs(i, j);
					if (isPeak) ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInArea(nx, ny)) {
				if (map[nx][ny] > map[x][y]) isPeak = false;
				if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
					visited[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
	}
	
	static boolean isInArea(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}
