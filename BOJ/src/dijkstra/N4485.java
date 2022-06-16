package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N4485 {
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;
		
		Node (int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	static int N;
	static final int INF = 987654321;
	
	static int[][] map;
	static int[][] minCost;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int t = 1; ;t++) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			map = new int[N][N];
			minCost = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					minCost[i][j] = INF;
				}
			}
			
			sb.append("Problem ").append(t).append(": ").append(dijkstra()).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		minCost[0][0] = map[0][0];
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				
				int cost = minCost[node.x][node.y] + map[nx][ny];
				
				if (minCost[nx][ny] > cost) {
					minCost[nx][ny] = cost;
					pq.offer(new Node(nx, ny, cost));
				}
			}
		}
		
		return minCost[N - 1][N - 1];
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N;
	}
	
}
