package contest_776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			String s = br.readLine();
			String c = br.readLine();
			
			boolean flag = false;
			
			for (int i = 0; i < s.length(); i+=2) {
				String c1 = String.valueOf(s.charAt(i));
				if (c.equals(c1)) {
					flag = true;
					break;
				}
			}
			
			if (flag) sb.append("YES").append('\n');
			else sb.append("NO").append('\n');
		}
		
		System.out.println(sb);
	}
}
