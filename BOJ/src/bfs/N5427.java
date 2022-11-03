package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5427 {
	
	static class Node {
		int x;
		int y;
		int time;
		boolean isFire;
		
		Node(int x, int y, boolean isFire) {
			this.x = x;
			this.y = y;
			this.isFire = isFire;
		}
		
		Node(int x, int y, int time, boolean isFire) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.isFire = isFire;
		}
	}
	
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];
			q = new LinkedList<>();
			Node start = null;
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
					
					if (map[i][j] == '@') {
						start = new Node(i, j, 0, false);
					}
					else if (map[i][j] == '*') {
						q.offer(new Node(i, j, true));
					}
				}
			}
			
			int ans = bfs(start);
			if (ans == -1) sb.append("IMPOSSIBLE");
			else sb.append(ans);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int bfs(Node start) {
		q.offer(start);
		visited[start.x][start.y] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int t = 0; t < size; t++) {
				Node cur = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if (isEscape(nx, ny)) {
						if (!cur.isFire) return cur.time + 1;
						continue;
					}
					
					if (cur.isFire && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
						map[nx][ny] = '*';
						q.offer(new Node(nx, ny, true));
					}
					
					else if (!cur.isFire && !visited[nx][ny] && map[nx][ny] == '.') {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, cur.time + 1, false));
					}
				}
			}
		}
		
		return -1;
	}
	
	static boolean isEscape(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= M;
	}
}