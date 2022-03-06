package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9461 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		long[] P = new long[101];
		P[1] = P[2] = P[3] = 1;
		P[4] = P[5] = 2;
		
		for (int i = 6; i < 101; i++) {
			P[i] = P[i - 1] + P[i - 5];
		}
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(P[N]).append('\n');
		}
		
		System.out.println(sb);
	}
}
