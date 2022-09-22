package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N25501 {
	
	static int rCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String s = br.readLine();
			rCount = 0;
			
			sb.append(recursion(s, 0, s.length() - 1)).append(' ').append(rCount).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int recursion(String s, int left, int right) {
		rCount++;
		if (left >= right) return 1;
		else if (s.charAt(left) != s.charAt(right)) return 0;
		else return recursion(s, left + 1, right - 1);
	}
}
