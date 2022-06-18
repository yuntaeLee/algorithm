package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1240 {
	
	static class Node {
		int to;
		int dist;
		
		Node (int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
	
	static int N, M;
	
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, dist));
			list.get(b).add(new Node(a, dist));
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(start, end)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int bfs(int start, int end) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start, 0));
		boolean[] visited = new boolean[N + 1];
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (visited[cur.to]) continue;
			
			visited[cur.to] = true;
			
			for (Node next : list.get(cur.to)) {
				int dist = cur.dist + next.dist;
				q.offer(new Node(next.to, dist));
				
				if (next.to == end) return dist;
			}
		}
		
		return -1;
	}
}
