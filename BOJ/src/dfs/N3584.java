package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N3584 {
	
	static int N;
	static int[] parent;
	static int[] depth;
	
	static List<List<Integer>> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			depth = new int[N + 1];
			
			tree = new ArrayList<>();
			
			for (int i = 0; i <= N; i++) {
				tree.add(new ArrayList<>());
			}
			
			boolean[] roots = new boolean[N + 1];
			
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				tree.get(A).add(B);
				
				roots[B] = true;
			}
			
			int root = 0;
			for (int i = 1; i <= N; i++) {
				if (!roots[i]) {
					root = i;
					break;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dfs(root, 1, 0);
			
			sb.append(LCA(a, b)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int LCA(int a, int b) {
		int ad = depth[a];
		int bd = depth[b];
		
		while (ad > bd) {
			a = parent[a];
			ad--;
		}
		
		while (bd > ad) {
			b = parent[b];
			bd--;
		}
		
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		return a;
	}
	
	static void dfs(int cur, int p, int d) {
		parent[cur] = p;
		depth[cur] = d;
		
		for (int next : tree.get(cur)) {
			if (next != p) {
				dfs(next, cur, d + 1);
			}
		}
	}
}
