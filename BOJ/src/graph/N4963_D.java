package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4963_D {
	
	static int w, h;
	static int[][] map;
	
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, 1, 1, -1, -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String s;
		while (!(s = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(s, " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(solution()).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int solution() {
		int answer = 0;
		
		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				if (map[x][y] == 1) {
					dfs(x, y);
					answer++;
				}
			}
		}
		
		return answer;
	}
	
	static void dfs(int x, int y) {
		map[x][y] = 2;
		
		for (int i = 0; i < 8; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx >= 0 && yy >= 0 && xx < h && yy < w) {
				if (map[xx][yy] == 1) {
					dfs(xx, yy);
				}
			}
		}
	}
}
