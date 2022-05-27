package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12051 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			int pd = Integer.parseInt(st.nextToken());
			int pg = Integer.parseInt(st.nextToken());
			
			sb.append('#').append(t).append(' ');
			
			if (isPossible(n, pd, pg)) sb.append("Possible").append('\n');
			else sb.append("Broken").append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	static boolean isPossible(long n, int pd, int pg) {
		if (pd != 0 && pg == 0) return false;
		if (pd != 100 && pg == 100) return false;
		
		for (long i = 1; i <= n; i++) {
			if ((double)i * pd / 100 == i * pd / 100) {
				return true;
			}
		}
		
		return false;
    }
	
}
