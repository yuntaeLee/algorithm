package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] alphabets = new char[26];
		for (int i = 97; i < 123; i++) {
			alphabets[i - 97] = (char)i;
		}
		
		int[] result = new int[26];
		Arrays.fill(result, -1);
		
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 97;
			
			if (s.charAt(i) == alphabets[idx]) {
				result[idx] = i;
				alphabets[idx] = '.';
			}
			
		}
		
		for (int n : result) sb.append(n).append(' ');
		
		System.out.println(sb);
	}
}
