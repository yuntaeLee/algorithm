package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int n = a % 10;
			
			if (n % 10 == 0) {
				sb.append(10).append('\n');
				continue;
			}
			
			for (int i = 1; i < b; i++) {
				n = (n * a) % 10;
			}
			
			sb.append(n).append('\n');
		}
		
		System.out.println(sb);
	}
}
