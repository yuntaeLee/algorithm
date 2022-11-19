package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N15230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String input = br.readLine();
			char target = 'a';
			int count = 0;
			
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == target++) {
					count++;
				} else {
					break;
				}
			}
			
			sb.append('#').append(t).append(' ').append(count).append('\n');
		}
		
		System.out.println(sb);
	}
}
