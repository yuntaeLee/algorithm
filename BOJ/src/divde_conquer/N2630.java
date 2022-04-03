package divde_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2630 {
	
	static int whiteCount;
	static int blueCount;
	
	static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divde(0, 0, N);
		
		sb.append(whiteCount).append('\n').append(blueCount);
		System.out.println(sb);
	}
	
	static void divde(int x, int y, int dist) {
		
		if (isSameColor(x, y, dist)) {
			if (paper[x][y] == 0) whiteCount++;
			else blueCount++;
			return;
		}
		
		else {
			int dist2 = dist / 2;
			divde(x, y, dist2); // 1사분면
			divde(x + dist2, y, dist2); // 2사분면
			divde(x, y + dist2, dist2); // 3사분면
			divde(x + dist2, y + dist2, dist2); // 4사분면
		}
	}
	
	static boolean isSameColor(int x, int y, int dist) {
		int color = paper[x][y];
		for (int i = x; i < x + dist; i++) {
			for (int j = y; j < y + dist; j++) {
				if (paper[i][j] != color) return false;
			}
		}
		
		return true;
	}
}
