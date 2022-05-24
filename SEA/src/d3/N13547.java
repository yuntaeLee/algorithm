package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N13547 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			String s = br.readLine();
			int sum = 0;
			
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'x') sum++;
			}
			
			sb.append('#').append(i).append(' ');
			if (sum >= 8) sb.append("NO");
			else sb.append("YES");
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
