package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11060 {
	
	static int n;
	static int[] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(n == 1 ? 0 : bfs(0));
	}
	
	static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[n];
		q.offer(start);
		dist[start] = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 1; i <= map[cur]; i++) {
				int next = cur + i;
				
				if (outOfArea(next)) continue;
				
				if (dist[next] == 0) {
					dist[next] = dist[cur] + 1;
					q.offer(next);
				}
				
				if (next == n - 1) return dist[next] - 1;
			}
		}
		
		return -1;
	}
	
	static boolean outOfArea(int x) {
		return x < 0 || x >= n;
	}
}
