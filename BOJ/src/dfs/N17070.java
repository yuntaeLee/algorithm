package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17070 {
	
	static int ans;
	static int N;
	
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int direction) {
		if (x == N - 1 && y == N - 1) {
			ans++;
			return;
		}
		
		// 가로
		if (direction == 0) {
			if (y + 1 < N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
		}
		
		// 세로
		else if (direction == 1) {
			if (x + 1 < N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
		}
		
		// 대각선
		else {
			if (x + 1 < N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
			if (y + 1 < N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
		}
		
		// 모든 경우의 수에 대각선 가능
		if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
			dfs(x + 1, y + 1, 2);
		}
	}

}
