package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3187 {
	
	static int s, w, ts, tw;
	static int R, C;
	
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				
				if (!visited[i][j] && map[i][j] != '#') {
					tw = ts= 0;
					dfs(i, j);
					
					if (ts > tw) s += ts;
					else w += tw;
				}
			}
		}
		
		sb.append(s).append(' ').append(w);
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		if (map[x][y] == 'v') tw++;
		else if (map[x][y] == 'k') ts++; 
		
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (outOfArea(nx, ny)) continue;
			
			if (!visited[nx][ny] && map[nx][ny] != '#') {
				dfs(nx, ny);
			}
		}
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= R || y >= C;
	}
}
