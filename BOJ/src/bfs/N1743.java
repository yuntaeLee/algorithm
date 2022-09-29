package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1743 {
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static boolean[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		
		int K = Integer.parseInt(st.nextToken());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r][c] = true;
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (!visited[i][j] && map[i][j]) {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		visited[x][y] = true;
		
		int ans = 1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				
				if (!visited[nx][ny] && map[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
					ans++;
				}
			}
		}
		
		return ans;
	}
	
	static boolean outOfArea(int x, int y) {
		return x <= 0 || y <= 0 || x > N || y > M;
	}

}
