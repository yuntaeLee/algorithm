package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1647 {
	
	static int[] parent;
	static ArrayList<Node> list;
	
	static class Node implements Comparable<Node> {
		int start;
		int end;
		int weight;
		
		Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node n) {
			return weight - n.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list.add(new Node(A, B, C));
		}
		
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(list);
		
		// Kruskal
		int ans = 0;
		int bigCost = 0;
		for (int i = 0; i < list.size(); i++) {
			Node n = list.get(i);
			
			// 사이클이 발생하지 않는 경우
			if (find(n.start) != find(n.end)) {
				ans += n.weight;
				union(n.start, n.end);
				bigCost = n.weight;
			}
		}
		
		System.out.println(ans - bigCost);
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) parent[y] = x;
	}

}
