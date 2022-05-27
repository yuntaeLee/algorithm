package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12741 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int maxStart = 0;
			int minEnd = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			maxStart = Math.max(a, c);
			minEnd = Math.min(b, d);
			
			int ans = minEnd - maxStart < 0 ? 0 : minEnd - maxStart;
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

}
