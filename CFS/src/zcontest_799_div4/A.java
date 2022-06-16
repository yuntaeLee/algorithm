package zcontest_799_div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			for (int i = 0; i < 3; i++) {
				if (Integer.parseInt(st.nextToken()) > a) ans++;
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

}
