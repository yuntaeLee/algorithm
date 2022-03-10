package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1260 {
	
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		visited = new boolean[N + 1];
		dfs(V);
		sb.append('\n');

		visited = new boolean[N + 1];
		bfs(V);
		
		System.out.println(sb);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(' ');
		
		for (int i = 1; i < graph.length; i++) {
			if (!visited[i] && graph[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		
		// 현재 노드를 방문처리
		visited[v] = true;
		sb.append(v).append(' ');
		
		// 큐가 빌 때까지 반복
		while (!q.isEmpty()) {
			// 큐에서 하나의 원소를 뽑아 출력
			int x = q.poll();

			// 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
			for (int i = 1; i < graph.length; i++) {
				if (!visited[i] && graph[x][i] == 1) {
					q.offer(i);
					visited[i] = true;
					sb.append(i).append(' ');
				}
			}
		}
	}
}
