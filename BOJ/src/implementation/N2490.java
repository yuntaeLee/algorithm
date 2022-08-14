package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2490 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			char ans = 'A' - 1;
			
			for (int j = 0; j < 4; j++) {
				if (Integer.parseInt(st.nextToken()) == 0) ans++;
			}
			
			if (ans == '@') sb.append('E').append('\n');
			else sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

}
