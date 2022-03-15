package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1697 {
	
	static int N, K;
	static int[] map = new int[100001];
	
	static int[] dx = { 1, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		
		if (N == K) System.out.println(0);
		else System.out.println(map[K] - 1);
	}
	
	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		map[n] = 1;
		
		while (!q.isEmpty()) {
			int x = q.poll();
			dx[2] = x;
			
			for (int i = 0; i < 3; i++) {
				int xx = x + dx[i];
				
				if (xx >= 0 && xx < map.length && map[xx] == 0) {
					q.offer(xx);
					map[xx] = map[x] + 1;
					
					if (xx == K) return;
				}
			}
		}
	}
}
