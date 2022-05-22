package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class N1261 {
	
	static class Node {
		int x;
		int y;
		int crush;
		
		Node (int x, int y, int crush) {
			this.x = x;
			this.y = y;
			this.crush = crush;
		}
	}
	
	static int M, N;
	
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0, 0));	
	}
	
	static int bfs(int x, int y) {
		Deque<Node> dq = new ArrayDeque<>();
		dq.offer(new Node(x, y, 0));
		map[x][y] = -1;
		
		while (!dq.isEmpty()) {
			Node cur = dq.poll();
			
			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.crush;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (isInArea(nx, ny)) {
					
					if (map[nx][ny] == 0) {
						dq.addFirst(new Node(nx, ny, cur.crush));
					}
					else if (map[nx][ny] == 1) {
						dq.offer(new Node(nx, ny, cur.crush + 1));
					}
					
					map[nx][ny] = -1;
				}
			}
		}
		
		return -1;
	}
	
	static boolean isInArea(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}
