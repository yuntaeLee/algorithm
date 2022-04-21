package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2252 {
	
	static int N;
	static int M;
	
	static int[] degree;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		degree = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		};
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			degree[B]++;
		}
		
		topologySort();
		
	}
	
	static void topologySort() {
		int[] result = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		
		// 진입 차수가 0인 노드를 큐에 삽입
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) q.offer(i);
		}
		
		// 위상 정렬이 완전히 수행되려면 정확히 N개의 노드를 방문
		for (int i = 1; i <= N; i++) {
			
			int x = q.poll();
			result[i] = x;
			
			for (int j = 0; j < graph.get(x).size(); j++) {
				int y = graph.get(x).get(j);
				
				// 새롭게 진입차수가 0이 된 정점을 큐에 삽입
				if (--degree[y] == 0) {
					q.offer(y);
				}
			}
		}
		
		print(result);
	}
	
	static void print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
