package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1012_B {
	
	static int N, M;
	static int count;
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0 ,-1 };
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			graph = makeGraph(N, M, K);
			visited = new boolean[N][M];
			count = 0;
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if(!visited[x][y] && graph[x][y] == 1) {
						bfs(x, y);
						count++;
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int[][] makeGraph(int n, int m, int k) throws IOException {
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[y][x] = 1;
		}
		
		return arr;
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int xx = xy[0] + dx[i];
				int yy = xy[1] + dy[i];
				
				if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
					if (!visited[xx][yy] && graph[xx][yy] == 1) {
						q.offer(new int[] {xx, yy});
						visited[xx][yy] = true;
					}
				}
			}
		}
		
	}
}
