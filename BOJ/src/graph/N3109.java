package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3109 {
	
	static int count;
	static int R, C;
	static char[][] map;
	
	static int[] dx = new int[] { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) count++;
		}
		
		System.out.println(count);
	}
	
	static boolean dfs(int x, int y) {
		for (int i = 0; i < 3; i++) {
			int xx = x + dx[i];
			int yy = y + 1;

//			if (xx < 0 || yy < 0 || xx >= R || yy >= C) continue;
//			
//			if (map[xx][yy] == 'x') continue;
//			
//			map[xx][yy] = 'x';
//			
//			if (dfs(xx,yy)) return true;
			
			if (xx >= 0 && yy >= 0 && xx < R && yy < C) {
				if (map[xx][yy] == '.') {
					map[xx][yy] = 'x';
					if (yy == C - 1) return true;
					if (dfs(xx, yy)) return true;
				}
			}
		}
		return false;
	}
}
