package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N11779 {
	
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		Node (int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return cost - n.cost;
		}
	}
	
	static final int INF = 987654321;
	static int n, m;
	
	static int[] dist;
	static int[] route;
	
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dist = new int[n + 1];
		route = new int[n + 1];
		
		init();
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		Stack<Integer> routes = searchPath(end);
		
		sb.append(dist[end]).append('\n').append(routes.size()).append('\n');
		while (!routes.isEmpty()) {
			sb.append(routes.pop()).append(' ');
		}
	
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		Queue<Node> q = new LinkedList<>();
		
		q.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.to;
			
			if (curNode.cost > dist[cur]) continue;
			
			for (Node next : graph.get(cur)) {
				int nextCost = dist[cur] + next.cost;
				
				if (dist[next.to] > nextCost) {
					dist[next.to] = nextCost;
					q.offer(new Node(next.to, nextCost));
					
					route[next.to] = cur;
				}
			}
		}
	}
	
	static Stack<Integer> searchPath(int e) {
		Stack<Integer> stk = new Stack<>();
		while (e != 0) {
			stk.push(e);
			e = route[e];
		}
		
		return stk;
	}
	
	static void init() {
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}
	}
}
