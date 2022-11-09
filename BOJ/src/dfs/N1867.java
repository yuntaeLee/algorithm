package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1867 {
	
	static boolean[] v;
	static int[] matched;
	static List<List<Integer>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		matched = new int[n + 1];
		
		edges = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			edges.add(new ArrayList<>());
		}
		
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.get(r).add(c);
		}
		
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (edges.get(i).size() == 0) continue;
			
			v = new boolean[n + 1];
			if (dfs(i)) cnt++; 
		}
		
		System.out.println(cnt);
	}
	
	static boolean dfs(int row) {
		for (int col : edges.get(row)) {
			if (v[col]) continue;
			v[col] = true;
			
			if (matched[col] == 0 || dfs(matched[col])) {
				matched[col] = row;
				return true;
			}
		}
		
		return false;
	}
}
