package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1068 {
	
	static int N;
	static int count;
	
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		
		int root = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			if (parent[i] == -1) root = i;
		}
		
		int d = Integer.parseInt(br.readLine());
		deleteNode(d);
		
		visited = new boolean[N];
		getLeafCount(root);
		
		System.out.println(count);
	}
	
	static void deleteNode(int d) {
		parent[d] = -2;
		for (int i = 0; i < N; i++) {
			if (parent[i] == d) {
				deleteNode(i);
			}
		}
	}
	
	static void getLeafCount(int v) {
		boolean isLeaf = true;
		visited[v] = true;
		
		if (parent[v] != -2) {
			for (int i = 0; i < N; i++) {
				if (parent[i] == v && !visited[i]) {
					getLeafCount(i);
					isLeaf = false;
				}
			}
			
			if (isLeaf) count++;
		}
	}
}
