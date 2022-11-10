package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1948 {
	
	static class City {
		int to;
		int time;
		
		City(int to, int time) {
			this.to = to;
			this.time = time;
		}
	}
	
	static int cnt;
	static int n, m;
	static int[] dist;
	static int[] inDegree;
	static boolean[] visited;
	
	static List<List<City>> graph;
	static List<List<City>> reverseGraph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		inDegree = new int[n + 1];
		visited = new boolean[n + 1];
		dist = new int[n + 1];
		
		graph = new ArrayList<>();
		reverseGraph = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			reverseGraph.add(new ArrayList<>());
		}
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new City(to, time));
			reverseGraph.get(to).add(new City(from, time));
			inDegree[to]++;
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		sb.append(topologySort(start, end)).append('\n').append(cnt);
		System.out.println(sb);
	}
	
	static int topologySort(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (City c : graph.get(cur)) {
				int next = c.to;
				int time = c.time;
				
				if (--inDegree[next] == 0) {
					q.offer(next);
				}
				
				if (dist[next] < dist[cur] + time) {
					dist[next] = dist[cur] + time;
				}
			}
		}
		
		dfs(end);
		
		return dist[end];
	}
	
	static void dfs(int start) {
		if (visited[start]) return;
		visited[start] = true;
		
		for (City c : reverseGraph.get(start)) {
			int next = c.to;
			int time = c.time;
			
			if (dist[start] == dist[next] + time) {
				cnt++;
				dfs(next);
			}
		}
	}
}
