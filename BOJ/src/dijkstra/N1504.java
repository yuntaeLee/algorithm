package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1504 {
	
	static final int INF = 98765432;
	
	static int N, E;
	
	static int[][] graph;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[N + 1][N + 1];
		dist = new int[N + 1];
		
		init();
		
		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = c;
		}
		
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int ans = Math.min(dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N),
						   dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N)); 
		
		System.out.println(ans >= INF ? -1 : ans);
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		boolean[] visited = new boolean[N + 1];
		
		pq.offer(new int[] {1, start});
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int u = cur[1];
			
			if (u == end) {
				return dist[u];
			}
			
			if (visited[u]) continue;
			
			visited[u] = true;
			for (int v = 1; v <= N; v++) {
				if (dist[v] > dist[u] + graph[u][v]) {
					dist[v] = dist[u] + graph[u][v];
					pq.offer(new int[] {dist[v], v});
				}
			}
		}
		
		return INF;
	}
	
	static void init() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) graph[i][j] = 0;
				else 		graph[i][j] = INF;
			}
		}
	}
	
}
