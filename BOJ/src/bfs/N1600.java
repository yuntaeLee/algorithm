package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1600 {
	
	static class Node {
		int x;
		int y;
		int cnt;
		int k;
		
		Node (int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	static int K, M, N;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dx = {-1, 0, 1, 0, -2, -2, 1, -1, 2, 2, -1, 1};
	static int[] dy = {0, -1, 0, 1, -1, 1, -2, -2, 1, -1, 2, 2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs(0, 0));
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.cnt;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (outOfArea(nx, ny)) continue;
				
				if (!visited[nx][ny][cur.k] && map[nx][ny] == 0) {
					visited[nx][ny][cur.k] = true;
					q.offer(new Node(nx, ny, cur.cnt + 1, cur.k));
				}
			}
			
			if (cur.k == K) continue;
			
			for (int d = 4; d < 12; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (outOfArea(nx, ny)) continue;
				
				if (!visited[nx][ny][cur.k + 1] && map[nx][ny] == 0) {
					visited[nx][ny][cur.k + 1] = true;
					q.offer(new Node(nx, ny, cur.cnt + 1, cur.k + 1));
				}
			}
		}
		
		return -1;
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= M;
	}
}
