package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N14502_2 {
	
	static int ans = Integer.MIN_VALUE;
	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static List<int[]> virusList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = Integer.parseInt(st.nextToken());
				
				if (copyMap[i][j] == 2) virusList.add(new int[] {i, j});
			}
		}
		
		setWall(0, 0);
		System.out.println(ans);
	}
	
	static void setWall(int start, int depth) {
		if (depth == 3) {
			copyMap();
			
			for (int[] xy : virusList) {
				dfs(xy[0], xy[1]);
			}
			
			ans = Math.max(ans, getSafeArea());
			return;
		}
		
		for (int i = start; i < N * M; i++) {
			int x = i / M;
			int y = i % M;
			
			if (copyMap[x][y] == 0) {
				copyMap[x][y] = 1;
				setWall(i + 1, depth + 1);
				copyMap[x][y] = 0;
			}
		}
	}
	
	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
				if (map[xx][yy] == 0) {
					map[xx][yy] = 2;
					dfs(xx, yy);
				}
			}
		}
	}
	
	static void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}
	
	static int getSafeArea() {
		int safeArea = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) safeArea++;
			}
		}
		
		return safeArea;
	}
}
