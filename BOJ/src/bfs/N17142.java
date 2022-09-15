package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17142 {
	
	static class Node {
		int x;
		int y;
		int time;
		
		Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int ans = Integer.MAX_VALUE;
	static int N, M;
	static int originEmptyCnt;
	
	static int[][] map;
	static Node[] picked;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static List<Node> viruses = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		picked = new Node[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 0) 
					originEmptyCnt++;
				
				else if (map[i][j] == 2) 
					viruses.add(new Node(i, j, 0));
			}
		}
		
		if (originEmptyCnt == 0) System.out.println(0);
		else {
			selectVirus(0, 0);
			System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		}
	}
	
	static void selectVirus(int start, int count) {
		if (count == M) {
			spreadVirus(originEmptyCnt);
			return;
		}
		
		for (int i = start; i < viruses.size(); i++) {
			picked[count] = viruses.get(i);
			selectVirus(i + 1, count + 1);
		}
	}
	
	static void spreadVirus(int emptyCnt) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < M; i++) {
			Node n = picked[i];
			visited[n.x][n.y] = true;
			q.offer(n);
		}
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				if (visited[nx][ny] || map[nx][ny] == 1) continue;
				
				if (map[nx][ny] == 0) emptyCnt--;
				
				if (emptyCnt == 0) {
					ans = Math.min(ans, cur.time + 1);
					return;
				}
				
				visited[nx][ny] = true;
				q.offer(new Node(nx, ny, cur.time + 1));
			}
		}
		
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N;
	}
}
