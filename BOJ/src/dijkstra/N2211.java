package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N2211 {
	
	static class Node implements Comparable<Node> {
		int v;
		int cost;
		
		Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	static final int INF = (int)1e9;
	static int n, m;
	static int[] dist;
	static int[] path;
	
	static List<List<Node>> graph = new ArrayList<>();
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		dijkstra(1);
		
		print();
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for (Node node : graph.get(cur.v)) {
				int next = node.v;
				int cost = node.cost;
				
				if (cost > dist[next]) continue;
				
				if (dist[next] > dist[cur.v] + cost) {
					dist[next] = dist[cur.v] + cost;
					pq.offer(new Node(next, dist[next]));
					
					path[next] = cur.v;
				}
			}
		}
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		for (int v = 2; v <= n; v++) {
			if (path[v] == 0) continue;
			cnt++;
			sb.append(v).append(' ').append(path[v]).append('\n');
		}
		
		ans.append(cnt).append('\n').append(sb);
		System.out.println(ans);
	}

	static void init() {
		dist = new int[n + 1];
		path = new int[n + 1];
		
		for (int i = 0; i <= n; i++) {
			dist[i] = INF;
			graph.add(new ArrayList<>());
		}
	}
}