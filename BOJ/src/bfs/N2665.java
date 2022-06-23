package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N2665 {
	
	static int N;
	
	static char[][] map;
	static int[][] dist;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		System.out.println(dist[N - 1][N - 1]);
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		dist[0][0] = 0;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				
				if (dist[nx][ny] > dist[cur[0]][cur[1]]) {
					if (map[nx][ny] == '1') dist[nx][ny] = dist[cur[0]][cur[1]];
					else dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
					
					q.offer(new int[] {nx, ny});
				}
			}
			
		}
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N;
	}
}
