package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1238 {
	
	static class Node implements Comparable<Node> {
		int v;
		int t;
		
		Node (int v, int t) {
			this.v = v;
			this.t = t;
		}
		
		@Override
		public int compareTo(Node o) {
			return t - o.t;
		}
		
	}
	
	static final int INF = 987654321;
	
	static int N;
	static ArrayList<ArrayList<Node>> list, reverseList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		reverseList = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, t));
			reverseList.get(b).add(new Node(a, t));
		}
		
		int[] dist = dijstra(X, list);
		int[] reverseDist = dijstra(X, reverseList);
		
		int ans = 0;
		
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dist[i] + reverseDist[i]);
		}
		
		System.out.println(ans);
	}
	
	static int[] dijstra(int start, ArrayList<ArrayList<Node>> list) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		boolean[] visited = new boolean[N + 1];
		
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.v;
			
			if (visited[cur]) continue;
				visited[cur] = true;
				
			for (Node node : list.get(cur)) {
				if (dist[node.v] > dist[cur] + node.t) {
					dist[node.v] = dist[cur] + node.t;
					pq.offer(new Node(node.v, dist[node.v]));
				}
			}
		}
		
		return dist;
	}
}
