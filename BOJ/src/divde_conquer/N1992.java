package divde_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1992 {
	
	static char[][] arr;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		solution(0, 0, N);
		
		System.out.println(sb);
	}
	
	static void solution(int x, int y, int dist) {
		
		if (isSameNumber(x, y, dist)) {
			sb.append(arr[x][y]);
			return;
		}
		
		else {
			sb.append('(');
			int dist2 = dist / 2;
			
			solution(x, y, dist2);
			solution(x, y + dist2, dist2);
			solution(x + dist2, y, dist2);
			solution(x + dist2, y + dist2, dist2);
		}
		
		sb.append(')');
	}
	
	static boolean isSameNumber(int x, int y, int dist) {
		char c = arr[x][y];
		
		for (int i = x; i < x + dist; i++) {
			for (int j = y; j < y + dist; j++) {
				if (arr[i][j] != c) return false;
			}
		}
		
		return true;
	}
}
