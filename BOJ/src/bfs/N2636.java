package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2636 {
	
	static int ans;
	static int N, M;
	
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static List<Point> cheesePoints;
	
	static class Point {
		int x;
		int y;
		
		Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int total = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		List<Integer> counts = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) total++;
			}
		}
		
		while (total > 0) {
			cheesePoints = new ArrayList<>();
			
			bfs();
			meltedCheeses();
			
			counts.add(total);
			total -= cheesePoints.size();
		}
		
		sb.append(ans).append('\n').append(counts.get(counts.size() - 1));
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (outOfArea(nx, ny) || visited[nx][ny]) continue;
				
				Point p = new Point(nx, ny);
				visited[nx][ny] = true;
				
				if (map[nx][ny] == 1) cheesePoints.add(p);
				else q.offer(p);
			}
		}
		
		ans++;
	}
	
	static void meltedCheeses() {
		for (int i = 0; i < cheesePoints.size(); i++) {
			Point p = cheesePoints.get(i);
			map[p.x][p.y] = 0;
		}
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= M;
	}

}
