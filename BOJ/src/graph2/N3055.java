package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3055 {
	
	static class Node {
		int x;
		int y;
		int dist;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		Node (int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	static int R, C;
	static char[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static Queue<Node> q = new LinkedList<>();
	static Queue<Node> water = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				
				if (map[i][j] == 'S') q.offer(new Node(i, j, 0));
				else if (map[i][j] == '*') water.offer(new Node(i, j));
			}
		}
		
		int ans = bfs();
		
		if (ans == -1) System.out.println("KAKTUS");
		else System.out.println(ans);
	}
	
	static int bfs() {
		
		while (!q.isEmpty()) {
			waterMove();
			
			int len = q.size();
			for (int i = 0; i < len; i++) {
				Node cur = q.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					
					if (isInArea(nx, ny)) {
						if (map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							q.offer(new Node(nx, ny, cur.dist + 1));	
						}
						
						if (map[nx][ny] == 'D') {
							return cur.dist + 1;
						}	
					}
				}
			}
		}
		
		return -1;
	}
	
	static void waterMove() {
		int len = water.size();
		for (int i = 0; i < len; i++) {
			Node cur = water.poll();
			
			for (int j = 0; j < 4; j++) {
				int nx = cur.x + dx[j];
				int ny = cur.y + dy[j];
				
				if (isInArea(nx, ny) && map[nx][ny] == '.') {
					map[nx][ny] = '*';
					water.offer(new Node(nx, ny));
				}
			}
		}
	}
	
	static boolean isInArea(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}
	
}
