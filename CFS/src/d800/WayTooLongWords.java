package d800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WayTooLongWords {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String s = br.readLine();
			
			if (s.length() > 10) {
				s = s.replace(s.substring(1, s.length() - 1), String.valueOf(s.length()-2));
			}
			
			sb.append(s).append('\n');
		}
		
		System.out.println(sb);
	}
}
