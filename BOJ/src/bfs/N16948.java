package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16948 {
	
	static class Knight {
		int x;
		int y;
		int cnt;
		
		Knight (int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int N;
	static int x1, y1;
	static int x2, y2;
	
	static int[][] board;
	static boolean[][] visited;
	
	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		
		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Knight> q = new LinkedList<>();
		q.offer(new Knight(x1, y1, 0));
		visited[x1][y1] = true;
		
		while (!q.isEmpty()) {
			Knight cur = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				
				if (nx == x2 && ny == y2) {
					return cur.cnt + 1;
				}
				
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Knight(nx, ny, cur.cnt + 1));
				}
			}
		}
		
		return -1;
	}
	
	static boolean outOfArea(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= N;
	}
}
