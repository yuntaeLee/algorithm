package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1107 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		
		if (M != 0) {
			st = new StringTokenizer(br.readLine());
			
			while (M-- > 0) {
				int n = Integer.parseInt(st.nextToken());
				broken[n] = true;
			}
		}
		
		int ans = Math.abs(N - 100);
		
		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean isBreak = true;
			for (int j = 0; j < len; j++) {
				if (broken[str.charAt(j) - '0']) {
					isBreak = false;
					break;
				}
			}
			
			if (isBreak) {
				 int min = Math.abs(N - i) + len;
				 ans = Math.min(min, ans);
			}
		}
		
		System.out.println(ans);
	}
}
