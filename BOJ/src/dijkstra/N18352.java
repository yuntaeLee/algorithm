package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N18352 {
	
	static int N, M, K, X;
	static int[] dist;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1];
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}
		
		dijkstra();
		
		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				sb.append(i).append('\n');
				flag = true;
			}
		}
		
		System.out.println(flag ? sb : -1);
	}
	
	static void dijkstra() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(X);
		dist[X] = 0;
		
		while (!pq.isEmpty()) {
			int cur  = pq.poll();
			
			for (int next : graph.get(cur)) {
				if (dist[next] > dist[cur] + 1) {
					dist[next] = dist[cur] + 1;
					pq.offer(next);
				}
			}
		}
	}
}
