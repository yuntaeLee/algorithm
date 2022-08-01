package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2251 {
	
	static int A, B, C;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	static class Bottle {
		int a;
		int b;
		int c;
		
		Bottle(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		bfs();
		
		Collections.sort(ans);
		for (int val : ans) {
			sb.append(val).append(' ');
		}
		
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Bottle> q = new LinkedList<>();
		boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];
		q.offer(new Bottle(0, 0, C));
		
		while (!q.isEmpty()) {
			Bottle cur = q.poll();
			
			if (visited[cur.a][cur.b][cur.c]) continue;
			
			if (cur.a == 0) ans.add(cur.c);
			
			visited[cur.a][cur.b][cur.c] = true;
			
			// B -> A
			if (cur.a + cur.b <= A) {
				q.offer(new Bottle(cur.a + cur.b, 0, cur.c));
			} else {
				q.offer(new Bottle(A, cur.a + cur.b - A, cur.c));
			}
			
			// C -> A
			if (cur.a + cur.c <= A) {
				q.offer(new Bottle(cur.a + cur.c, cur.b, 0));
			} else {
				q.offer(new Bottle(A, cur.b, cur.a + cur.c - A));
			}
			
			// A -> B
			if (cur.a + cur.b <= B) {
				q.offer(new Bottle(0, cur.a + cur.b, cur.c));
			} else {
				q.offer(new Bottle(cur.a + cur.b - B, B, cur.c));
			}
			
			// C -> B
			if (cur.b + cur.c <= B) {
				q.offer(new Bottle(cur.a, cur.b + cur.c, 0));
			} else {
				q.offer(new Bottle(cur.a, B, cur.b + cur.c - B));
			}
			
			// A -> C
			if (cur.a + cur.c <= C) {
				q.offer(new Bottle(0, cur.b, cur.a + cur.c));
			} else {
				q.offer(new Bottle(cur.a + cur.c - C, cur.b, C));
			}
			
			// B -> C
			if (cur.b + cur.c <= C) {
				q.offer(new Bottle(cur.a, 0, cur.b + cur.c));
			} else {
				q.offer(new Bottle(cur.a, cur.b + cur.c - C, C));
			}
		}
	}
}
