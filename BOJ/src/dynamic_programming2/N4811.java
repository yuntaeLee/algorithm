package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4811 {
	
	static long[][] dp = new long[31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			sb.append(eat(n, 0)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static long eat(int w, int h) {
		if (dp[w][h] != 0) return dp[w][h];
		
		if (w == 0) return 1;
		else if (h == 0) return dp[w][h] = eat(w - 1, h + 1);
		else return dp[w][h] = eat(w - 1, h + 1) + eat(w, h - 1);
	}

}