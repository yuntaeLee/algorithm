package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9461_2 {
	
	static Long[] P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		P = new Long[101];
		
		P[0] = 0L;
		P[1] = P[2] = P[3] = 1L;
		P[4] = P[5] = 2L;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(recur(N)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static long recur(int N) {
		
		if (P[N] == null) {
			P[N] = recur(N - 1) + recur(N - 5);
		}
		
		return P[N];
	}
}
