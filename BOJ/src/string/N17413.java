package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N17413 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringBuilder ss = new StringBuilder();
		
		boolean flag = false;
		for (char c : br.readLine().toCharArray()) {
			
			if (c == '<' || c == ' ') {
				sb.append(ss.reverse()).append(c);
				ss.setLength(0);
				
				if (c == '<') flag = true;
			}
			
			else if (c == '>') {
				flag = false;
				sb.append(c);
			}
			
			else {
				if (flag) sb.append(c);
				else ss.append(c);
			}
		}
		
		sb.append(ss.reverse());
		
		System.out.println(sb);
	}
}
