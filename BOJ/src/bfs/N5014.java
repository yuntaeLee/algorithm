package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5014 {
	
	static int F, S, G;
	
	static int[] map;
	static boolean[] visited;
	
	static int[] dx = new int[2];
	
	static class Node {
		int floor;
		int cnt;
		
		Node (int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		dx[0] = Integer.parseInt(st.nextToken());
		dx[1] = -Integer.parseInt(st.nextToken());
	
		map = new int[F + 1];
		visited = new boolean[F + 1];
		
		bfs();
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(S, 0));
		visited[S] = true;
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			if (n.floor == G) {
				System.out.println(n.cnt);
				return;
			}
			
			for (int i = 0; i < 2; i++) {
				int next = n.floor + dx[i];
				
				if (outOfFloor(next)) continue;
				
				if (!visited[next]) {
					visited[next] = true;
					q.offer(new Node(next, n.cnt + 1));
				}
			}
		}
		
		System.out.println("use the stairs");
	}
	
	static boolean outOfFloor(int f) {
		return f <= 0 || f > F;
	}
}
