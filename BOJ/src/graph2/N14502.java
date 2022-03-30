package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N14502 {
	
	static int ans = Integer.MIN_VALUE;
	static int N;
	static int M;
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(ans);
	}
	
	static void dfs(int depth) {
		if (depth == 3) {
			int[][] copyMap = new int[N][M];
			arrCopy(copyMap, map);
			bfs();
			arrCopy(map, copyMap);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) q.add(new int[] {i, j});
			}
		}
		
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int xx = xy[0] + dx[i];
				int yy = xy[1] + dy[i];
				
				if (xx >= 0 && yy >= 0 && xx < N && yy < M && map[xx][yy] == 0) {
					map[xx][yy] = 2;
					q.add(new int[] {xx, yy});
				}
			}
		}
		
		getSafeArea();
	}
	
	static void arrCopy(int[][] target, int[][] org) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				target[i][j] = org[i][j];
			}
		}
	}
	
	static void getSafeArea() {
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) sum++;
			}
		}
		
		ans = Math.max(sum, ans);
	}

}
