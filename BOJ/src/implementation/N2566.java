package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2566 {
	
	static class Max {
		int num;
		int row;
		int col;
		
		Max (int num, int row, int col) {
			this.num = num;
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Max ans = new Max(Integer.MIN_VALUE, -1, -1);
		
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= 9; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n > ans.num) {
					ans.num = n;
					ans.row = i;
					ans.col = j;
				}
			}
		}
		
		sb.append(ans.num).append('\n').append(ans.row).append(' ').append(ans.col);
		System.out.println(sb);
	}
}
