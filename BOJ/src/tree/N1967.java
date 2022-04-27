package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N1967 {
	
	static class Node {
		int node;
		int dist;
		
		Node (int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}
	
	static int N;
	static int max;
	static int maxIdx;
	
	static boolean[] visited;
	
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[parent].add(new Node(child, weight));
			list[child].add(new Node(parent, weight));
		}
		
		visited = new boolean[N + 1];
		visited[1] = true;
		dfs(1, 0);
		
		visited = new boolean[N + 1];
		visited[maxIdx] = true;
		dfs(maxIdx, 0);
		
		System.out.println(max);
	}
	
	static void dfs(int idx, int dist) {
		
		if (max < dist) {
			max = dist;
			maxIdx = idx;
		}
		
		for (Node n : list[idx]) {
			if (!visited[n.node]) {
				visited[n.node] = true;
				dfs(n.node, dist + n.dist);
			}
		}
	}
}
