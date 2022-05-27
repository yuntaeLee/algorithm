package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N13218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int ans = Integer.parseInt(br.readLine()) / 3;
			
			sb.append('#').append(i).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

}
