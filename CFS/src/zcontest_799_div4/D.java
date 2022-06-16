package zcontest_799_div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
	
	static String time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			
			int start = (s.charAt(0) - '0') * 600 +
						(s.charAt(1) - '0') * 60 +
						(s.charAt(3) - '0') * 10 +
						(s.charAt(4) - '0');
			
			int time = start;
			int ans = 0;
			while (true) {
				if (isPalindrome(time)) ans++;
				time = (time + x) % 1440; // 24 * 60
				if (time == start) break;
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	
	static boolean isPalindrome(int x) {
		int h = x / 60;
		int m = x % 60;
		
		if (h / 10 + h % 10 * 10 == m) return true;
		
		return false;
	}
}
