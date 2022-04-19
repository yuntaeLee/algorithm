package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	
	int to;
	int from;
	int distance;
	
	Node (int to, int from, int distance) {
		this.to = to;
		this.from = from;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.distance - o.distance;
	}
	
}

public class N1197 {
	
	static int ans;
	static int V;
	static int E;
	
	static int[] parent;
	
	static Queue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];
		
		resetMap();
		
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(A, B, C));
		}
		
		kruskal();
		
		System.out.println(ans);
	}
	
	static void kruskal() {
		int size = pq.size();
		
		for (int i = 0; i < size; i++) {
			
			Node node = pq.poll();
			int to = find(node.to);
			int from = find(node.from);
			
			// 사이클이 발생하지 않는 경우 그래프에 포함
			if(!isSameParent(to, from)) {
				ans += node.distance;
				union(node.to, node.from);
			}
		}
	}
	
	static void resetMap() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	
	// 부모 노드를 찾는 함수
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	// 두 부모 노드를 합치는 함수
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	// 같은 부모를 가지는지 확인
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		return x == y;
	}
}
