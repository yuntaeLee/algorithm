package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N3687 {
	
	static Long[] minDp = new Long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		fillMinDpArray();
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(minDp[n]).append(' ').append(getMax(n)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void fillMinDpArray() {
		Arrays.fill(minDp, Long.MAX_VALUE);
		
		minDp[2] = 1L;
		minDp[3] = 7L;
		minDp[4] = 4L;
		minDp[5] = 2L;
		minDp[6] = 6L;
		minDp[7] = 8L;
		minDp[8] = 10L;
		
		int[] min = {0, 0, 1, 7, 4, 2, 0, 8};
		
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				String s = "" + minDp[i - j] + min[j];
				minDp[i] = Math.min(minDp[i], Long.parseLong(s));
			}
		}
	}
	
	static String getMax(int n) {
		StringBuilder max = new StringBuilder();
		
		if (n % 2 == 0) max.append('1');
		else max.append('7');
		
		for (int i = 0; i < n / 2 - 1; i++) {
			max.append('1');
		}
		
		return max.toString();
	}
}
