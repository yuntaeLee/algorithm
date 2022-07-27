package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class N13913 {
	
	static int N, K;
	static int[] time = new int[100001];
	static int[] parent = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		Stack<Integer> stk = new Stack<>();
		stk.push(K);
		int idx = K;
		
		while (idx != N) {
			stk.push(parent[idx]);
			idx = parent[idx];
		}
		
		sb.append(time[K] - 1).append('\n');
		while (!stk.isEmpty()) {
			sb.append(stk.pop()).append(' ');
		}
		
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		time[N] = 1;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (now == K) return;
			
			for (int i = 0; i < 3; i++) {
				int next;
				
				if (i == 0) 	 next = now + 1;
				else if (i == 1) next = now - 1;
				else 			 next = now * 2;
				
				if (next < 0 || next > 100000) continue;
				
				if (time[next] == 0) {
					time[next] = time[now] + 1;
					q.offer(next);
					parent[next] = now;
				}
			}
		}
	}
}
