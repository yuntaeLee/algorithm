package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16236 {
	
	static int time;
	static int eat;
	static int size = 2;
	
	static int sx;
	static int sy;
	
	static int N;
	
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static ArrayList<Node> fishes;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dist;
		
		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			if (dist != o.dist) {
				return dist - o.dist;
			}
			
			return x - o.x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					map[i][j] = 0;
					sx = i;
					sy = j;
				}
			}
		}
		
		while (true) {
			fishes = new ArrayList<>();
			
			bfs(sx, sy);
			
			if (fishes.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Collections.sort(fishes);
			
			Node eatingFish = fishes.get(0);
			
			time += eatingFish.dist;
			eat++;
			
			map[eatingFish.x][eatingFish.y] = 0;
			sx = eatingFish.x;
			sy = eatingFish.y;
			
			if (eat == size) {
				size++;
				eat = 0;
			}
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		
		boolean[][] visited = new boolean[N][N];
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (isInArea(nx, ny) && isMovable(nx, ny) && !visited[nx][ny]) {
					
					if (isEatable(nx, ny)) {
						fishes.add(new Node(nx, ny, cur.dist + 1));
					}
					
					q.offer(new Node(nx, ny, cur.dist + 1));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	static boolean isMovable(int x, int y) {
		return map[x][y] <= size;
	}
	
	static boolean isEatable(int x, int y) {
		return map[x][y] != 0 && map[x][y] < size;
	}
	
	static boolean isInArea(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

}
