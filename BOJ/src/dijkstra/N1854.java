package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1854 {
	
	static class Node implements Comparable<Node> {
		int v;
		int time;
		
		Node(int v, int time) {
			this.v = v;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			return time - o.time;
		}
	}
	
	static final int INF = (int) 1e9;
	static int n, m, k;
	static List<List<Node>> graph = new ArrayList<>();
	static List<PriorityQueue<Integer>> dist = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		init();
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
		}
		
		dijkstra(1);
		
		print();
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist.get(start).add(0);
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for (Node node : graph.get(cur.v)) {
				int next = node.v;
				int time = node.time;
				
				if (dist.get(next).size() < k) {
					dist.get(next).offer((cur.time + time) * -1);
					pq.offer(new Node(next, cur.time + time));
				}
				else if ((dist.get(next).peek() * -1) > cur.time + time) {
					dist.get(next).poll();
					dist.get(next).offer((cur.time + time) * -1);
					pq.offer(new Node(next, cur.time + time));
				}
			}
		}
	}
	
	static void print() {
		for (int i = 1; i <= n; i++) {
			if (dist.get(i).size() == k) sb.append(dist.get(i).peek() * -1);
			else sb.append(-1);
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void init() {
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			dist.add(new PriorityQueue<>());
		}
	}
}
