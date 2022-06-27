package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1963 {
	
	static boolean[] primes = new boolean[10000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		eratos();
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(A, B)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static String bfs(int A, int B) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(A);
		
		int[] dist = new int[10000];
		dist[A] = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					if (i == 0 && j == 0) continue;
					
					int next = change(cur, i, j);
					if (!primes[next] && dist[next] == 0) {
						q.offer(next);
						dist[next] = dist[cur] + 1;
					}
					
					if (next == B) {
						return String.valueOf(dist[next] - 1);
					}
				}
			}
		}
		
		return "Impossible";
	}
	
	static int change(int num, int i, int j) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		sb.setCharAt(i, (char)(j + '0'));
		return Integer.parseInt(sb.toString());
	}
	
	static void eratos() {
		primes[0] = primes[1] = true;
		
		for (int i = 2; i < Math.sqrt(10000); i++) {
			if (primes[i]) continue;
			
			for (int j = i * i; j < 10000; j += i) {
				primes[j] = true;
			}
		}
	}
}
