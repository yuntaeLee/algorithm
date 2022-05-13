package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16928 {
	
	static int[] map = new int[101];
	static int[] distance = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start] = end;
		}
		
		bfs();
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		distance[1] = 0;
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if (cur == 100) {
				System.out.println(distance[cur]);
				return;
			}
			
			for (int i = 1; i < 7; i++) {
				int next = cur + i;
				
				if (next > 100) continue;
				if (visited[next]) continue;
				
				visited[next] = true;
				
				if (map[next] == 0) {
					distance[next] = distance[cur] + 1;
					q.offer(next);
				}
				
				else {
					if (!visited[map[next]]) {
						visited[map[next]] = true;
						distance[map[next]] = distance[cur] + 1;
						q.offer(map[next]);
					}
				}
			}
		}
	}

}
