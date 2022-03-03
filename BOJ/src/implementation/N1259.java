package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1259 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s;
		while (!(s = br.readLine()).equals("0")) {
			int first = 0;
			int last = s.length() - 1;
			boolean flag = true;
			
			while (first < last) {
				
				if (s.charAt(first) == s.charAt(last)) {
					first++;
					last--;
				} else {
					flag = false;
					break;
				}
			}
			
			if (flag) sb.append("yes").append('\n');
			else sb.append("no").append('\n');
		}
		
		System.out.println(sb);
	}
}
