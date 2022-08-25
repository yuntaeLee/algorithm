package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N1786 {
	
	static List<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String text = br.readLine();
		String pattern = br.readLine();
		
		int[] pi = getPi(pattern);
		kmp(pi, text, pattern);
		
		sb.append(ans.size()).append('\n');
		for (int val : ans) sb.append(val).append(' ');
		
		System.out.println(sb);
	}
	
	static void kmp(int[] pi, String text, String pattern) {
		int textLen = text.length();
		int patternLen = pattern.length();
		int j = 0;
		
		for (int i = 0; i < textLen; i++) {
			while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			
			if (text.charAt(i) == pattern.charAt(j)) {
				if (j + 1 == patternLen) {
					ans.add(i - patternLen + 2);
					j = pi[j];
				}
				
				else j++;
			}
		}
	}
	
	static int[] getPi(String text) {
		int len = text.length();
		int[] pi = new int[len];
		int j = 0;
		
		// i는 접미사, j는 접두사
		for (int i = 1; i < len; i++) {
			while (j > 0 && text.charAt(i) != text.charAt(j)) { // j > 0 (최소 두 글자부터 비교)
				j = pi[j - 1]; // 건너 뜀
			}
			
			if (text.charAt(i) == text.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
}
