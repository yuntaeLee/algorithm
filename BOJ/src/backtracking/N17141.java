package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17141 {
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int ans = Integer.MAX_VALUE;
	static int count;
	static int N, M;
	static int[][] map;
	static boolean[] checked;
	static Node[] v;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static List<Node> virus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 0) count++;
				
				else if (map[i][j] == 2) {
					map[i][j] = 0;
					virus.add(new Node(i, j));
				}
			}
		}
		
		count += virus.size() - M;
		
		if (count == 0) ans = 0;
		else {
			v = new Node[M];
			checked = new boolean[virus.size()];
			comb(0, 0);
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void comb(int start, int depth) {
		if (depth == M) {
			int[][] cmap = copyMap(map);
			int cnt = bfs(cmap, count);
			
			if (cnt != -1) {
				ans = Math.min(ans, cnt);
			}
			
			return;
		}
		
		for (int i = start; i < virus.size(); i++) {
			if (!checked[i]) {
				checked[i] = true;
				v[depth] = virus.get(i);
				comb(i + 1, depth + 1);
				checked[i] = false;
			}
		}
	}
	
	static int bfs(int[][] map, int cnt) {
		Queue<Node> q = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			Node n = v[i];
			map[n.x][n.y] = 2;
			q.offer(new Node(n.x, n.y));
		}
		
		int time = 0;
		while (!q.isEmpty()) {
			if (ans <= time) break;
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if (outOfArea(nx, ny)) continue;
					
					if (map[nx][ny] == 0) {
						map[nx][ny] = 2;
						q.offer(new Node(nx, ny));
						cnt--;
					}
				}
			}
			
			time++;
			if (cnt == 0) return time;
		}
		
		return -1;
	}
	
	static int[][] copyMap(int[][] map) {
		int[][] ans = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans[i][j] = map[i][j];
			}
		}
		
		return ans;
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N;
	}
}
