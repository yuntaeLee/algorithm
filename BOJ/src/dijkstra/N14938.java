package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N14938 {

	static class Point implements Comparable<Point> {
		int n;
		int dist;
		
		Point(int n, int dist) {
			this.n = n;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Point o) {
			return dist - o.dist;
		}
	}
	
	static final int INF = (int)1e9;
	static int n, m, r;
	static int[] item;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<ArrayList<Point>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		item = new int[n + 1];
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) { 
			graph.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Point(b, l));
			graph.get(b).add(new Point(a, l));
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dijkstra(i));
		}
		
		System.out.println(ans);
	}
	
	static int dijkstra(int start) {
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int cur = pq.poll().n;
			
			visited[cur] = true;
			
			for (Point next : graph.get(cur)) {
				if (!visited[next.n] && dist[next.n] > dist[cur] + next.dist) {
					dist[next.n] = dist[cur] + next.dist;
					pq.offer(new Point(next.n, dist[next.n]));
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] <= m) ans += item[i];
		}
		
		return ans;
	}
}
