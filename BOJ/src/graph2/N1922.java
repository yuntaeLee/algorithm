package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1922 {
	
	static int N;
	static int M;
	
	static int[] parent;
	
	static Queue<Node> pq = new PriorityQueue<>();
	
	static class Node implements Comparable<Node> {
		
		int to;
		int from;
		int dist;
		
		Node (int to, int from, int dist) {
			this.to = to;
			this.from = from;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N + 1];
		resetArr();
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a, b, c));
		}
		
		System.out.println(kruskal());
	}
	
	static int kruskal() {
		int ans = 0;
		int size = pq.size();
		
		for (int i = 0; i < size; i++) {
			Node node = pq.poll();
			
			if (!isSameParent(node.to, node.from)) {
				ans += node.dist;
				union(node.to, node.from);
			}
		}
		
		return ans;
	}
	
	static void resetArr() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x < y) parent[y] = x;
		else  parent[x] = y;
	}
	
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		return x == y;
	}
}
