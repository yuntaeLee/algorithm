package bfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2206 {
	
	static class Node {
		int x;
		int y;
		int dist;
		int isDistroyed;
		
		Node(int x, int y, int dist, int isDistroyed) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.isDistroyed = isDistroyed;
		}
	}
	
	static int N;
	static int M;
	
	static char[][] map;
	static boolean[][][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[2][N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.dist;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (outOfMap(nx, ny)) continue;

				if (map[nx][ny] == '1' && cur.isDistroyed == 1) continue;

				int isDistroyed = cur.isDistroyed;
				if (map[nx][ny] == '1' && cur.isDistroyed == 0) {
					isDistroyed = 1;
				}

				if (!visited[isDistroyed][nx][ny]) {
					q.offer(new Node(nx, ny, cur.dist + 1, isDistroyed));
					visited[isDistroyed][nx][ny] = true;
				}
			}
		}
		
		return -1;
	}

	static boolean outOfMap(int x, int y) {
		return x < 0 || y < 0 || x >=N || y >= M;
	}
}
