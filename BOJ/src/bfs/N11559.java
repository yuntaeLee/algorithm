package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N11559 {
	
	static class Puyo {
		int x;
		int y;
		
		Puyo (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int ans;
	
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static List<Puyo> booms;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		visited = new boolean[12][6];
		
		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		while (true) {
			visited = new boolean[12][6];
			boolean flag = false;
			
			for (int i = 11; i >= 0; i--) {
				for (int j = 5; j >= 0; j--) {
					
					if (!visited[i][j] && map[i][j] == '.') continue;
					
					booms = new ArrayList<>();
					booms.add(new Puyo(i, j));
					
					if (bfs(i, j, map[i][j]) >= 4) {
						flag = true;
						boom();
					}
				}
			}
			
			if (!flag) break;

			ans++;
			fall();
		}
		
		System.out.println(ans);
	}
	
	static void fall() {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j >= 0; j--) {
				if (map[j][i] != '.') q.offer(map[j][i]);
				map[j][i] = '.';
			}
			
			int h = 11;
			while (!q.isEmpty()) {
				map[h--][i] = q.poll();
			}
		}
	}
	
	static void boom() {
		for (int i = 0; i < booms.size(); i++) {
			Puyo p = booms.get(i);
			map[p.x][p.y] = '.';
		}
	}
	
	static int bfs(int x, int y, char c) {
		Queue<Puyo> q = new LinkedList<>();
		q.offer(new Puyo(x, y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Puyo cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				
				if (!visited[nx][ny] && map[nx][ny] == c) {
					visited[nx][ny] = true;
					booms.add(new Puyo(nx, ny));
					q.offer(new Puyo(nx, ny));
				}
			}
		}
		
		return booms.size();
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= 12 || y >= 6;
	}
}