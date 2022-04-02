package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10026 {
	
	static int N;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		sb.append(solution()).append(' ');
		
		changeRtoG();
		
		sb.append(solution());
		
		System.out.println(sb);
	}
	
	static int solution() {
		visited = new boolean[N][N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					count += dfs(i, j);
				}
			}
		}
		
		return count;
	}
	
	static int dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx >= 0 && yy >= 0 && xx < N && yy < N) {
				if (!visited[xx][yy] && map[xx][yy] == map[x][y]) {
					dfs(xx, yy);
				}
			}
		}
		
		return 1;
	}
	
	static void changeRtoG() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') map[i][j] = 'G';
			}
		}
	}
}
