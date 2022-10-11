package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1719 {
	
	static class Node implements Comparable<Node> {
		int v;
		int cost;
		
		Node (int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	static final int INF = (int)1e9;
	static int N, M;
	
	static int[] dist;
	static int[] route;
	
	static List<List<Node>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, cost));
			graph.get(v).add(new Node(u, cost));
		}
		
		for (int i = 1; i <= N; i++) {
			dist = new int[N + 1];
			route = new int[N + 1];
			Arrays.fill(dist, INF);
			dijkstra(i);
		}
		
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.cost > dist[cur.v]) continue;
			
			for (Node next : graph.get(cur.v)) {
				if (dist[next.v] > dist[cur.v] + next.cost) {
					dist[next.v] = dist[cur.v] + next.cost;
					pq.offer(new Node(next.v, dist[next.v]));
					
					route[next.v] = cur.v;
				}
			}
		}
		
		markRoute(start);
	}
	
	static void markRoute(int n) {
		for (int i = 1; i <= N; i++) {
			sb.append(i == n ? "-" : find(n, i)).append(' ');
		}
		
		sb.append('\n');
	}
	
	static int find(int start, int i) {
		if (route[i] == start) return i;
		return find(start, route[i]);
	}
}
