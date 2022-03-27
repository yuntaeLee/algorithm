package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N24678 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int even = 0;
			
			st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				
				if (n % 2 == 0) even++;
			}
			
			if (even == 3 || even == 2) sb.append('R').append('\n');
			else sb.append('B').append('\n');
		}
		
		System.out.println(sb);
	}

}
