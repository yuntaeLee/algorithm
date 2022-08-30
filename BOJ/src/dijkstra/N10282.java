package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N10282 {
	
	static class Computer implements Comparable<Computer> {
		int to;
		int time;
		
		Computer (int to, int time) {
			this.to = to;
			this.time = time;
		}
		
		@Override
		public int compareTo(Computer o) {
			return time - o.time;
		}
	}
	
	static final int INF = (int)1e9;
	static int[] dist;
	static ArrayList<ArrayList<Computer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			dist = new int[n + 1];
			graph = new ArrayList<>();
			
			for (int i = 0; i <= n; i++) {
				dist[i] = INF;
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				graph.get(b).add(new Computer(a, s));
			}
			
			dijkstra(c);
			
			int cnt = 0;
			int total = 0;
			
			for (int i = 1; i <= n; i++) {
				if (dist[i] != INF) {
					cnt++;
					total = Math.max(total, dist[i]);
				}
			}
			
			sb.append(cnt).append(' ').append(total).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Computer> pq = new PriorityQueue<>();
		pq.offer(new Computer(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Computer node = pq.poll();
			int dis = node.time;
			int cur = node.to;
			
			if (dist[cur] < dis) continue;
			
			for (Computer next : graph.get(cur)) {
				if (dist[next.to] > dist[cur] + next.time) {
					dist[next.to] = dist[cur] + next.time;
					pq.offer(new Computer(next.to, dist[next.to]));
				}
			}
		}
	}
}
