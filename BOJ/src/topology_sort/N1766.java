package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1766 {
	
	static int N; // 정점 수
	static int M; // 간선 수
	
	static int[] inDegree;
	
	static ArrayList<ArrayList<Integer>> graph;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inDegree = new int[N + 1];
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(v2);
			inDegree[v2]++;
		}
		
		topologySort();
	}
	
	static void topologySort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) pq.offer(i);
		}

		while (!pq.isEmpty()) {
			int v = pq.poll();
			
			sb.append(v).append(' ');
			
			for (int nv : graph.get(v)) {
				if (--inDegree[nv] == 0) {
					pq.offer(nv);
				}				
			}
		}
		
		System.out.println(sb);
	}
}
