package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2573 {
	
	static class IceBerg {
		int x;
		int y;
		
		IceBerg(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		int cnt = 0;
		
		while ((cnt = getIceBergCount()) < 2) {
			if (cnt == 0) {
				ans = 0;
				break;
			}
			
			melt();
			ans++;
		}
		
		System.out.println(ans);
	}
	
	static void melt() {
		Queue<IceBerg> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					q.offer(new IceBerg(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		while (!q.isEmpty()) {
			IceBerg berg = q.poll();
			int seaCnt = 0;
			
			for (int i = 0; i < 4; i++) {
				int nx = berg.x + dx[i];
				int ny = berg.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				
				if (map[nx][ny] == 0 && !visited[nx][ny]) {
					seaCnt++;
				}
			}
			
			if (map[berg.x][berg.y] - seaCnt < 0) {
				map[berg.x][berg.y] = 0;
			} 
			else {
				map[berg.x][berg.y] -= seaCnt;
			}
		}
	}
	
	static int getIceBergCount() {
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, visited);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (outOfArea(nx, ny)) continue;
			
			if (map[nx][ny] != 0 && !visited[nx][ny]) {
				dfs(nx, ny, visited);
			}
		}
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= M;
	}
}
