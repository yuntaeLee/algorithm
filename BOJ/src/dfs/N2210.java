package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N2210 {
	
	static int[][] map = new int[5][5];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static Set<Integer> ans = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				sb = new StringBuilder();
				dfs(i, j, 0, map[i][j]);
			}
		}

		System.out.println(ans.size());
	}
	
	static void dfs(int x, int y, int depth, int num) {
		if (depth == 5) {
			ans.add(num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (insideOfMap(nx, ny)) {
				dfs(nx, ny, depth + 1, num * 10 + map[nx][ny]);
			}
		}
	}
	
	static boolean insideOfMap(int x, int y) {
		return x >= 0 && y >= 0 && x < 5 && y < 5;
	}
}
