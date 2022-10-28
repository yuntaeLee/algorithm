package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[101][101];
		
		int cnt = 0;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int i = a; i < a + 10; i++) {
				for (int j = b; j < b + 10; j++) {
					if (!paper[i][j]) {
						paper[i][j] = true;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
