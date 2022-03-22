package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int count;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Point(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
}
public class N7562_2 {
	
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			visited = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine(), " ");
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine(), " ");
			Point target = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			sb.append(bfs(start, target)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int bfs(Point start, Point target) {
		Queue<Point> q = new LinkedList<>();
		visited[start.x][start.y] = true;
		q.add(start);
		int answer = 0;
		
		while (!q.isEmpty()) {
			Point now = q.poll();
			
			if (now.x == target.x && now.y == target.y) {
				answer = now.count;
			}
			
			for (int i = 0; i < 8; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				if (xx >= 0 && yy >= 0 && xx < N && yy < N && !visited[xx][yy]) {
					
					visited[xx][yy] = true;
					q.add(new Point(xx, yy, now.count + 1));
				}
			}
		}
		
		return answer;
	}
}
