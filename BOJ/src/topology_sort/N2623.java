package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2623 {
	
	static int N, M;
	
	static int[] inDegree;
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		inDegree = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < t - 1; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				graph.get(start).add(n);
				inDegree[n]++;
				start = n;
			}
		}
		
		topologySort();
		
		if (result.size() != N) sb.append(0).append('\n');
		else {
			for (int i = 0; i < result.size(); i++) {
				sb.append(result.get(i)).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) q.offer(i);
		}
		
		while (!q.isEmpty()) {
			int v = q.poll();
			result.add(v);
			
			for (int nv : graph.get(v)) {
				
				if (--inDegree[nv] == 0) {
					q.offer(nv);
				}
			}
		}
	}

}
