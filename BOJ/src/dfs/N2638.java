package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N2638 {
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int cheeseCnt;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static ArrayList<Point> cheeseList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cheeseList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) {
					cheeseList.add(new Point(i, j));
					cheeseCnt++;
				}
			}
		}
		
		int time = 0;
		
		while (cheeseCnt != 0) {
			time++;
			visited = new boolean[N][M];
			
			dfs(0, 0);
			melting();
		}
		
		System.out.println(time);
	}
	
	static void melting() {
		for (int i = 0; i < cheeseList.size(); i++) {
			int x = cheeseList.get(i).x;
			int y = cheeseList.get(i).y;
			int cnt = 0;
			
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if (map[nx][ny] == 2) {
					cnt++;
				}
			}
			
			if (cnt >= 2) {
				map[x][y] = 0;
				cheeseCnt--;
				cheeseList.remove(i);
				i--;
			}
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		map[x][y] = 2;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (outOfArea(nx, ny)) continue;
			if (visited[nx][ny] || map[nx][ny] == 1) continue;
			
			dfs(nx, ny);
		}
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= M;
	}
}
