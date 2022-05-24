package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			
			for (int j = 0; j < 10; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n % 2 == 1) sum += n;
			}
			
			sb.append('#').append(i).append(' ').append(sum).append('\n');
		}
		
		System.out.println(sb);
	}

}
