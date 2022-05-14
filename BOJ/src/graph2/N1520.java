package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1520 {
	
	static int N, M;
	
	static int[][] map;
	static int[][] dp;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	static int dfs(int x, int y) {
		
		if (x == N - 1 && y == M - 1) return 1;
		
		if (dp[x][y] != -1) return dp[x][y];
		
		else {
			dp[x][y] = 0;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if (map[nx][ny] < map[x][y]) {
					dp[x][y] += dfs(nx, ny);
				}
			}
		}
		
		return dp[x][y];
	}

}
