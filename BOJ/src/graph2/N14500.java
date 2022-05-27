package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14500 {
	
	static int ans;
	static int N, M;

	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
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
				
				dfs(i, j, 0, 0);
				exception(i, j);
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int depth, int sum) {
		
		if (depth == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isInArea(nx, ny) && !visited[nx][ny]) {
				
				visited[nx][ny] = true;
				dfs(nx, ny, depth + 1, sum + map[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}
	
	// 'ㅗ' 모양
	// '+' 모양에서 하나를 뺌
	static void exception(int x, int y) {
		int wing = 4;
		int sum = map[x][y];
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (wing <= 2) return;
			
			if (!isInArea(nx, ny)) {
				wing--;
				continue;
			}
			
			min = Math.min(min, map[nx][ny]);
			sum += map[nx][ny];
		}
		
		if (wing == 4) sum -= min;
		
		ans = Math.max(ans, sum);
	}
	
	static boolean isInArea(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	
}
