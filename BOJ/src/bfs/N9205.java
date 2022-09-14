package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9205 {
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		ArrayList<Node> list;
		ArrayList<ArrayList<Integer>> graph;
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			graph = new ArrayList<>();
			
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.add(new Node(x, y));
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					if (getManhattan(list.get(i), list.get(j)) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			
			sb.append(bfs(graph, n) ? "happy" : "sad").append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean bfs(ArrayList<ArrayList<Integer>> graph, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		boolean[] visited = new boolean[n + 2];
		visited[0] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if (cur == n + 1) return true;
			
			for (int next : graph.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		
		return false;
	}
	
	static int getManhattan(Node n1, Node n2) {
		return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
	}
}
