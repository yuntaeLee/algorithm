package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11725 {

	static int N;
	
	static int[] parents;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		
		for (int i = 1; i <= N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		bfs(1);
		
		for (int i = 2; i < parents.length; i++) {
			sb.append(parents[i]).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		parents[start] = 1;
		
		while (!q.isEmpty()) {
			int parent = q.poll();
			
			for (int i : graph.get(parent)) {
				if (parents[i] == 0) {
					parents[i] = parent;
					q.offer(i);
				}
			}
		}
	}
}
