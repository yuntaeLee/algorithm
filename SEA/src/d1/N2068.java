package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2068 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int ans = 0;
			
			for (int j = 0; j < 10; j++) {
				ans = Math.max(ans, Integer.parseInt(st.nextToken()));
			}
			
			sb.append('#').append(i).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
