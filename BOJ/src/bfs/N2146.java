package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2146 {
	
	static class Node {
		int x;
		int y;
		int cnt;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		Node (int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int ans = Integer.MAX_VALUE;
	static int N;
	static int landNum = 2;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					makeLand(i, j);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2) {
					visited = new boolean[N][N];
					bfs(i, j);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		visited[x][y] = true;
		int curLandNum = map[x][y];
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				if (!visited[nx][ny] && map[nx][ny] != curLandNum) {
					visited[nx][ny] = true;
					
					if (map[nx][ny] == 0) q.offer(new Node(nx, ny, n.cnt + 1));
					else ans = Math.min(ans, n.cnt);
				}
			}
		}
	}
	
	static void makeLand(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		map[x][y] = landNum;
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = landNum;
					q.offer(new Node(nx, ny));
				}
			}
		}
		
		landNum++;
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N;
	}
}
