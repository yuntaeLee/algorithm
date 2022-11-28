package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N4179 {
	
	static class Node {
		int x;
		int y;
		boolean isFire;
		
		Node(int x, int y, boolean isFire) {
			this.x = x;
			this.y = y;
			this.isFire = isFire;
		}
	}
	
	static int N, M;
	static char[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static List<Node> fires = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Node start = null;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				
				if (map[i][j] == 'J') {
					start = new Node(i, j, false);
				} else if (map[i][j] == 'F') {
					fires.add(new Node(i, j, true));
				}
			}
		}
		
		int ans = bfs(start);
		System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
	}
	
	static int bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		int[][] dist = new int[N][M];
		
		for (int i = 0; i < fires.size(); i++) {
			q.offer(fires.get(i));
		}
		
		q.offer(start);
		dist[start.x][start.y] = 1;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				boolean isFire = cur.isFire;
				
				if (isEscape(nx, ny)) {
					if (!isFire) {
						return dist[cur.x][cur.y];	
					} 
					
					continue;
				}
				
				if (map[nx][ny] == '.') {
					if (dist[nx][ny] == 0 && !isFire) {
						dist[nx][ny] = dist[cur.x][cur.y] + 1;
						q.offer(new Node(nx, ny, isFire));
					} else if (isFire) {
						map[nx][ny] = 'F';
						q.offer(new Node(nx, ny, isFire));
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
