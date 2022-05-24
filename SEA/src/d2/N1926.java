package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		char[] nums = {'3', '6', '9'};
		
		for (int i = 1; i <= N; i++) {
			String s = String.valueOf(i);
			int cnt = 0;
			
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				
				for (int k = 0; k < 3; k++) {
					if (c == nums[k]) {
						sb.append('-');
						cnt++;
					}
				}
			}
			
			if (cnt == 0) sb.append(i).append(' ');
			else sb.append(' ');
		}
		
		System.out.println(sb);
	}
}
