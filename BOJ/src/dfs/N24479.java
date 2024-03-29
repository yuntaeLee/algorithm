package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N24479 {
	
	static int d = 1;
	static int N, M, R;
	static int[] order;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		order = new int[N + 1];
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(order[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		order[start] = d++;
		
		for (int next : graph.get(start)) {
			if (order[next] == 0) {
				dfs(next);
			}
		}
	}
}
