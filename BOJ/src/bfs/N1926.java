package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1926 {
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, m;
	static int weight;
	static int cnt;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					weight = Math.max(weight, bfs(i, j));
					cnt++;
				}
			}
		}
		
		sb.append(cnt).append('\n').append(weight);
		System.out.println(sb);
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		int ans = 1;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (outOfArea(nx, ny)) continue;
				
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
					ans++;
				}
			}
		}
		
		return ans;
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= n || y >= m;
	}
}
