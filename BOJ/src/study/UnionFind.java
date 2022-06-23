package study;

import java.util.HashSet;

public class UnionFind {
	
	
	public static void main(String[] args) {
		int[] parent = new int[8];
		
		// 초기값 셋팅
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		union(parent, 1, 2);		
		union(parent, 2, 5);
		union(parent, 3, 4);
		union(parent, 2, 3);
		printParent(parent);
		
		System.out.println(connected(parent, 2, 4));
		
		System.out.println(connectedComponents(parent, 1));
	}
	
	// 부모 노드를 찾는 함수
	static int find(int[] parent, int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent, parent[x]);
	}
	
	
	// 두 부모 노드를 합치는 함수
	static void union(int[] parent, int a, int b) {
		a = find(parent, a);
		b = find(parent, b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	// 같은 부모를 가지는지 확인하는 함수
	static boolean connected(int[] parent, int a, int b) {
		return find(parent, a) == find(parent, b);
	}
	
	static int connectedComponents(int[] parent, int n) {
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 1; i < parent.length; i++) {
			set.add(parent[i]);
		}
		System.out.println(set);
		return set.size();
	}
	
	static void printParent(int[] parent) {
		for (int i = 1; i < parent.length; i++) System.out.print(parent[i] + " ");
		System.out.println();
	}
	
}
