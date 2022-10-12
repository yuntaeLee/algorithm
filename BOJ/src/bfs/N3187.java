package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3187 {
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int sheep, wolf;
	static int R, C;
	
	static char map[][];
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					bfs(i, j);
				}
			}
		}
		
		sb.append(sheep).append(' ').append(wolf);
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		visited[x][y] = true;
		int s = 0;
		int w = 0;
		
		if (map[x][y] == 'v') w++;
		else if (map[x][y] == 'k') s++;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				if (visited[nx][ny] || map[nx][ny] == '#') continue;
				
				visited[nx][ny] = true;
				q.offer(new Node(nx, ny));
				
				if (map[nx][ny] == 'v') w++;
				else if (map[nx][ny] == 'k') s++;
			}
		}
		
		if (s > w) sheep += s;
		else wolf += w;
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= R || y >= C;
	}
}
