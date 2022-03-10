package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2606 {
	
	static int count;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		bfs(1);
		System.out.println(count);
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(v);
		visited[v] = true;
		
		while (!q.isEmpty()) {
			
			int x = q.poll();
			
			for (int i = 1; i < graph.length; i++) {
				if (!visited[i] && graph[x][i] == 1) {
					q.offer(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}
}
