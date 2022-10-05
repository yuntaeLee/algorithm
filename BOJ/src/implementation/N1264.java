package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1264 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s;
		while (!(s = br.readLine()).equals("#")) {
			int cnt = 0;
			
			for (int i = 0; i < s.length(); i++) {
				char c = Character.toLowerCase(s.charAt(i));
				
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					cnt++;
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}

}
