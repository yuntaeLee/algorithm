package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1987 {
	
	static int ans;
	static int R;
	static int C;
	
	static int[][] map;
	static boolean[] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 1);
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int count) {
		visited[map[x][y]] = true;
		ans = Math.max(ans, count);
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx >= 0 && yy >= 0 && xx < R && yy < C) {
				if (!visited[map[xx][yy]]) {
					dfs(xx, yy, count + 1);
					visited[map[xx][yy]] = false;
				}
			}
		}
	}
}
