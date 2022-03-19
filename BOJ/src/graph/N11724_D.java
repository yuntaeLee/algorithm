package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11724_D {
	
	static int count;
	static int N, M;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = graph[y][x] =1;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = true;
		
		while (!q.isEmpty()) {
			int xx = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && graph[xx][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
