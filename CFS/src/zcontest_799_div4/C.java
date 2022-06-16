package zcontest_799_div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
	
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			br.readLine();
			map = new char[9][9];
			
			for (int i = 1; i < 9; i++) {
				String s = br.readLine();
				
				for (int j = 0; j < 8; j++) {
					map[i][j + 1] = s.charAt(j);
				}
			}
			
			boolean flag = false;
			
			for (int i = 2; i < 8; i++) {
				for (int j = 2; j < 8; j++) {
					if (isCorrectPoint(i, j)) {
						sb.append(i).append(' ').append(j).append('\n');
						flag = true;
						break;
					}
				}
				
				if (flag) break;
			}
		}
		
		System.out.println(sb);
	}
	
	static boolean isCorrectPoint(int x, int y) {
		int[] dx = {-1, -1, 1, 1};
		int[] dy = {1, -1, -1, 1};
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (map[nx][ny] == '.') return false;
		}
		
		return true;
	}

}
