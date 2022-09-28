package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1325 {
	
	static int idx;
	static int N, M;
	static int[] ans;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[N + 1];
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
		}
		
		
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, ans[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (ans[i] == max) sb.append(i).append(' ');
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					ans[next]++;
					q.offer(next);
				}
			}
		}
	}
}
