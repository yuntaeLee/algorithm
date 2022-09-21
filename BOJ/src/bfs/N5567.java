package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5567 {
	
	static int ans;
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		
		for (int i = 0; i < graph.get(1).size(); i++) {
			int n = graph.get(1).get(i);
			
			visited[n] = true;
			q.offer(n);
			ans++;
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int val : graph.get(cur)) {
				if (!visited[val]) {
					visited[val] = true;
					ans++;
				}
			}
		}
	}
}
