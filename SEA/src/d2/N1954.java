package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			int cnt = N;
			int col = -1;
			int row = 0;
			int k = 1;
			int oper = 1;
			
			while (true) {
				for (int i = 0; i < cnt; i++) {
					col += oper;
					arr[row][col] = k++;
				}
				
				if (--cnt == 0) break;
				
				for (int i = 0; i < cnt; i++) {
					row += oper;
					arr[row][col] = k++;
				}
				
				oper *= -1;
			}
			
			sb.append('#').append(t).append('\n');
			
			for (int[] ar : arr) {
				for (int val : ar) {
					sb.append(val).append(' ');
				}
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}

}