package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16234 {
	
	static int ans;
	static int N, L, R;
	
	static boolean isMovable;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		while (true) {
			isMovable = false;
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if (!visited[i][j]) {
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			
			if (!isMovable) break;
			
			ans++;
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		List<Node> list = new ArrayList<>();
		
		int count = 1;
		int sum = map[x][y];
		
		visited[x][y] = true;
		Node node = new Node(x, y);
		q.offer(node);
		list.add(node);
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (outOfTheMap(nx, ny) || visited[nx][ny]) continue;
				
				int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
				
				if (L <= diff && diff <= R) {
					Node next = new Node(nx, ny);
					q.offer(next);
					list.add(next);
					
					visited[nx][ny] = true;
					isMovable = true;
					sum += map[nx][ny];
					count++;
				}
			}
		}
		
		move(list, sum, count);
	}
	
	static void move(List<Node> list, int sum, int count) {
		if (count == 1) return;
		
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			map[node.x][node.y] = sum / count;
		}
	}
	
	static boolean outOfTheMap(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N;
	}

}
