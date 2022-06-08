package graph2;

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
		int count;
		int wall;
		
		Node(int x, int y, int count, int wall) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.wall = wall;
		}
	}
	
	static int N;
	static int M;
	
	static char[][] map;
	static boolean[][][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

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
		q.add(new Node(0, 0, 1, 0));
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (cur.x == N - 1 && cur.y == M - 1) {
				return cur.count;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if (map[nx][ny] == '1' && cur.wall == 1) continue;
				
				int isBreak = cur.wall;
				
				if (map[nx][ny] == '1' && cur.wall == 0) {
					isBreak = 1;
				}
				
				if (visited[isBreak][nx][ny]) continue;
				
				q.offer(new Node(nx, ny, cur.count + 1, isBreak));
				visited[isBreak][nx][ny] = true;
			}
		}
		
		return -1;
	}
}
