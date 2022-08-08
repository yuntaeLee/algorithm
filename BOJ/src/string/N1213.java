package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		int[] arr = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'A']++;
		}
		
		int odd = 0;
		int mid = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1) {
				mid = i;
				odd++;
			}
		}
		
		if ((s.length() % 2 == 1 && odd > 1) || (s.length() % 2 == 0 && odd > 0)) {
			sb.append("I'm Sorry Hansoo");
		}
		else {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i] / 2; j++) {
					sb.append(((char)(i + 'A')));
				}
			}
			
			String rev = getReverseString(sb);
			if (odd == 1) sb.append(((char)(mid + 'A')));
			sb.append(rev);
		}
		
		System.out.println(sb);
	}
	
	static String getReverseString(StringBuilder sb) {
		return new StringBuilder(sb).reverse().toString();
	}
}
