package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N13732 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = makeArray(N);
			
			sb.append('#').append(i).append(' ').append(checkSquare(arr)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static String checkSquare(char[][] arr) {
		boolean flag = true;
		int total = 0;
		int sx = 0;
		int sy = 0;
		int len = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == '#') {
					
					if (flag) {
						for (int k = j; k < arr.length; k++) {
							if (k == j) {
								sx = i;
								sy = k;
							}
							
							if (arr[i][k] == '#') len++;
							else break;
						}
						
						flag = false;
					}

					total++;
				}
			}
		}
		
		for (int i = sx; i < sx + len; i++) {
			for (int j = sy; j < sy + len; j++) {
				if (arr[i][j] != '#') return "no";
			}
		}
		
		if (Math.pow(len, 2) == total) return "yes";
		else return "no";
		
	}
	
	static char[][] makeArray(int N) throws IOException {
		char[][] result = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < N; j++) {
				result[i][j] = s.charAt(j);
			}
		}
		
		return result;
	}

}
