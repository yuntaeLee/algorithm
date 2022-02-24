package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] alphabets = new int[26];
		Arrays.fill(alphabets, -1);
		
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 97;
			
			if (alphabets[idx] == -1) alphabets[idx] = i;
		}
		
		for (int n : alphabets) sb.append(n).append(' ');
		
		System.out.println(sb);
	}
}