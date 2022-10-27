package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17471 {
	
	static int ans = Integer.MAX_VALUE;
	static int N;
	static int[] cost;
	static boolean[] isA;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N + 1];
		isA = new boolean[N + 1];
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < cnt; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		select(1);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void select(int depth) {
		if (depth == N) {
			if (isConnected()) {
				int sumA = 0;
				int sumB = 0;
				
				for (int i = 1; i <= N; i++) {
					if (isA[i]) sumA += cost[i];
					else sumB += cost[i];
				}
				
				ans = Math.min(ans, Math.abs(sumA - sumB));
			}
			
			return;
		}
		
		// A 선택
		isA[depth] = true;
		select(depth + 1);
		
		// A 미선택
		isA[depth] = false;
		select(depth + 1);
	}
	
	static boolean isConnected() {
		int sa = getStartNumber(true);
		int sb = getStartNumber(false);
		
		if (sa == -1 || sb == -1) return false;
		
		boolean[] visited = new boolean[N + 1];
		bfs(sa, visited, true);
		bfs(sb, visited, false);
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) return false;
		}
		
		return true;
	}
	
	static void bfs(int start, boolean[] visited, boolean area) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph.get(cur)) {
				if (isA[next] != area) continue;
				
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
	
	static int getStartNumber(boolean area) {
		for (int i = 1; i <= N; i++) {
			if (isA[i] == area) {
				return i;
			}
		}
		
		return -1;
	}
}
