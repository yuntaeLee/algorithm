package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1039 {
	
	static class Node {
		int num;
		int cnt;
		
		Node (int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	static int ans = -1;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[1000001][K + 1];
		
		q.offer(new Node(N, 0));
		visited[N][0] = true;
		
		while (!q.isEmpty()) {
			Node t = q.poll();
			
			if (t.cnt == K) {
				ans = Math.max(ans, t.num);
				continue;
			}
			
			int len = String.valueOf(t.num).length();
			
			for (int i = 0; i < len - 1; i++) {
				for (int j = i + 1; j < len; j++) {
					int next = swap(t.num, i, j);
					
					if (next != -1 && !visited[next][t.cnt + 1]) {
						q.offer(new Node(next, t.cnt + 1));
						visited[next][t.cnt + 1] = true;
					}
				}
			}
		}
	}
	
	static int swap(int n, int i, int j) {
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		
		if (i == 0 && sb.charAt(j) == '0') return -1;
		
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return Integer.parseInt(sb.toString());
	}
}
