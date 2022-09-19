package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N6087 {
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int mirror;
		int dir;
		
		Node (int x, int y, int mirror, int dir) {
			this.x = x;
			this.y = y;
			this.mirror = mirror;
			this.dir = dir;
		}
		
		@Override
		public int compareTo(Node o) {
			return mirror - o.mirror;
		}
	}
	
	static int W, H;
	static char[][] map;
	static int[][] dist;
	
	static Node start, end;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		dist = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			Arrays.fill(dist[i], W * H);
		}
		
		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
				
				if (map[i][j] == 'C') {
					if (start == null) start = new Node(i, j, 0, -1);
					else end = new Node(i, j, 0, -1);
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start.x][start.y] = 0;
		pq.offer(start);
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.x == end.x && cur.y == end.y) 
				return cur.mirror;
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (outOfArea(nx, ny) || map[nx][ny] == '*') continue;
				
				int nm = cur.mirror;
				
				// Refactor
				// 다른 방향일 경우 mirror 개수 추가
				if (cur.dir != d && cur.dir != -1) {
					nm++;
				}
				
				if (dist[nx][ny] < nm) continue;
				
				dist[nx][ny] = nm;
				pq.offer(new Node(nx, ny, nm, d));
				
//				// 같은 방향
//				if (cur.dir == d || cur.dir == -1) {
//					if (dist[nx][ny] >= cur.mirror) {
//						dist[nx][ny] = cur.mirror;
//						pq.offer(new Node(nx, ny, cur.mirror, d));
//					}
//				}
//				
//				// 다른 방향
//				else {
//					if (dist[nx][ny] >= cur.mirror + 1) {
//						dist[nx][ny] = cur.mirror + 1;
//						pq.offer(new Node(nx, ny, cur.mirror + 1, d));
//					}
//				}
			}
		}
		
		return -1;
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= H || y >= W;
	}
}
