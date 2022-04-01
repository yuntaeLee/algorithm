package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2468 {
	
	static int precipitation;
	static int ans;
	static int N;

	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				precipitation = Math.max(precipitation, map[i][j]);
			}
		}
		
		solution();
		
		System.out.println(ans);
	}
	
	static void solution() {
		for (int pre = 0; pre < precipitation; pre++) {
			int count = 0;
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > pre) {
						count += dfs(i, j, pre);
					}
				}
			}

			ans = Math.max(ans, count);
		}
	}
	
	static int dfs(int x, int y, int pre) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx >= 0 && yy >= 0 && xx < N && yy < N) {
				if (!visited[xx][yy] && map[xx][yy] > pre) {
					dfs(xx, yy, pre);
				}
			}
		}
		
		return 1;
	}
}
