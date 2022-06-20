package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1937 {
	
	static class Node {
		int x;
		int y;
		int bamboo;
		
		Node (int x, int y, int bamboo) {
			this.x = x;
			this.y = y;
			this.bamboo = bamboo;
		}
	}
	
	static int N;
	
	static int[][] map;
	static int[][] dp;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] == 0) {
					ans = Math.max(ans, dfs(i, j));
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static int dfs(int x, int y) {
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (outOfArea(nx, ny)) continue;
			
			if (map[nx][ny] > map[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
				dfs(nx, ny);
			}
		}
		
		return dp[x][y];
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N;
	}

}
