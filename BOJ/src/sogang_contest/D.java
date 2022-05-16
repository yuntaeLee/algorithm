package sogang_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String target = br.readLine();
		
		if (!isSameCount(input, target, N)) {
			System.out.println("NO");
			return;
		}
		
		String inputRm = getStringRemovedVowels(input);
		String targetRm = getStringRemovedVowels(target);
		
		if (inputRm.equals(targetRm)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
	
	static boolean isSameCount(String input, String target, int length) {
		int[] inputAlphabets = new int[26];
		int[] targetAlphabets = new int[26];
		
		for (int i = 0; i < length; i++) {
			char c1 = input.charAt(i);
			char c2 = target.charAt(i);
			
			inputAlphabets[c1 - 97]++;
			targetAlphabets[c2 - 97]++;
			
			if (i == 0 || i == length - 1) {
				if (c1 != c2) return false;
			}
		}
		
		for (int i = 0; i < 26; i++) {
			if (inputAlphabets[i] != targetAlphabets[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	static String getStringRemovedVowels(String s) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < s.length() - 1; i++) {
			char c = s.charAt(i);
			if (isConsonant(c)) sb.append(c);
		}
		
		return sb.toString();
	}
	
	static boolean isConsonant(char c) {
		return c != 'a' && c != 'e' && c != 'i' && c !='o' && c != 'u';
	}
}
