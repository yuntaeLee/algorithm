package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1916 {
	
	static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		Node (int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
		
	}
	
	static int N;
	static int M;
	
	static int[] dist;
	static boolean[] visited;
	
	static ArrayList<ArrayList<Node>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int startPos = Integer.parseInt(st.nextToken());
		int endPos = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(startPos, endPos));
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			
			if (!visited[cur]) {
				visited[cur] = true;
				
				for (Node node : list.get(cur)) {
					if (!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		
		return dist[end];
	}
}
