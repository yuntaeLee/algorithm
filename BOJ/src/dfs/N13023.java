package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N13023 {
	
	static boolean status;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, 1);
			
			if (status) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}
	
	static void dfs(int idx, int depth) {
		if (depth == 5) {
			status = true;
			return;
		}
		
		visited[idx] = true;
		for (int next : graph.get(idx)) {
			if (!visited[next]) {
				dfs(next, depth + 1);
			}
		}
		
		visited[idx] = false;
	}
}
