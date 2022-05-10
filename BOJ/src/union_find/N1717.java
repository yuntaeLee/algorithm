package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1717 {
	
	static int N;
	static int M;
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		setArray();
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (op == 0) union(a, b);
			else sb.append((isSameParent(a, b) ? "YES" : "NO")).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void setArray() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x < y) parent[y] = x;
		else parent[x] = y;
	}
	
	static int find(int x) {
		if (parent[x] == x) return x; 
		return parent[x] = find(parent[x]);
	}
	
	static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		return x == y;
	}

}
