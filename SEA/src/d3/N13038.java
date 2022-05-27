package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13038 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] week = new boolean[7];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				if (st.nextToken().equals("1")) week[i] = true;
			}
			
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < 7; i++) {
				if (!week[i]) continue;
				
				int start = i;
				int cnt = 0;
				int sum = 0;
				
				while (cnt != N) {
					if (week[start % 7]) cnt++;
					start++;
					sum++;
				}
				
				ans = Math.min(ans, sum);
			}
			
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
