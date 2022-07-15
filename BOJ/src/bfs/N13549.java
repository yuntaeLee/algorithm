package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N13549 {
	
	static class Node {
		int pos;
		int time;
		
		Node (int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
	
	static int min = Integer.MAX_VALUE;
	static int max = 100000;
	static int N, K;
	
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[max + 1];
		
		bfs();
		
		System.out.println(min);
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0));
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			visited[n.pos] = true;
			
			if (n.pos == K) min = Math.min(min, n.time);
			
			if (n.pos * 2 <= max && !visited[n.pos * 2]) q.offer(new Node(n.pos * 2, n.time));
			if (n.pos + 1 <= max && !visited[n.pos + 1]) q.offer(new Node(n.pos + 1, n.time + 1));
			if (n.pos - 1 >= 0 && !visited[n.pos - 1]) q.offer(new Node(n.pos - 1, n.time + 1));
		}
	}
}
