package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N1167 {
	
	static class Node {
		int to;
		int dist;
		
		Node (int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
	
	static int max;
	static int maxNode;
	static int V;
	
	static boolean[] visited;
	
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			while (true) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1) break;
				
				int dist = Integer.parseInt(st.nextToken());
				list.get(a).add(new Node(b, dist));
			}
		}
		
		visited = new boolean[V + 1];
		dfs(1, 0);
		
		visited = new boolean[V + 1];
		dfs(maxNode, 0);
		
		System.out.println(max);
	}
	
	static void dfs(int x, int dist) {
		if (dist > max) {
			max =  dist;
			maxNode = x;
		}
		
		visited[x] = true;
		
		for (Node next : list.get(x)) {
			if (!visited[next.to]) {
				dfs(next.to, next.dist + dist);
				visited[next.to] = false;
			}
		}
	}
}
