package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1707 {
	
	static int V, E;
	static int[] visited;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visited = new int[V + 1];
			graph = new ArrayList<>();
			
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			
			boolean ans = true;
			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0) {
					if (!bfs(i)) {
						ans = false;
						break;
					}
				}
			}
			
			sb.append(ans ? "YES" : "NO").append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean bfs(int head) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(head);
		visited[head] = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph.get(cur)) {
				if (visited[next] == visited[cur]) {
					return false;
				}
				if (visited[next] == 0) {
					visited[next] = visited[cur] * -1;
					q.offer(next);
				}
			}
		}
		
		return true;
	}
}
