package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1753 {
	
	static class Node implements Comparable<Node> {

		int v;
		int w;
		
		Node (int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
		
	}
	
	static final int INF = 1_000_000_000;
	
	static int V;
	static int E;
	
	static List<Node>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V + 1];
		dist = new int[V + 1];
		
		Arrays.fill(dist, INF);
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Node(v, w));
		}

		dijkstra(K);
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.v;
			
			if (visited[cur]) continue;
			visited[cur] = true;
			
			for (Node node : list[cur]) {
				if (dist[node.v] > dist[cur] + node.w) {
					dist[node.v] = dist[cur] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
	}
}
