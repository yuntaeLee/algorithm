package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7562 {
	
	static int N;
	static int[][] graph;
	static boolean[][] visited;

	static int[] start = new int[2];
	static int[] target = new int[2];
	
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
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			target[0] = Integer.parseInt(st.nextToken());
			target[1] = Integer.parseInt(st.nextToken());
			
			bfs(start[0], start[1]);
			
			sb.append(graph[target[0]][target[1]]).append('\n');
		}
		
		System.out.println(sb);		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int xx = xy[0] + dx[i];
				int yy = xy[1] + dy[i];
				
				if (xx >= 0 && yy >= 0 && xx < N && yy < N && !visited[xx][yy]) {	
					
					visited[xx][yy] = true;
					q.offer(new int[] {xx, yy});
					graph[xx][yy] = graph[xy[0]][xy[1]] + 1;
					
					if (xx == target[0] && yy == target[1]) {
						return;
					}
				}
			}
		}
	}
}
