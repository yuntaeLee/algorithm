package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1701 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		int ans = 0;
		
		for (int i = 0; i < len; i++) {
			ans = Math.max(ans, getMax(str.substring(i, len)));
		}
		
		System.out.println(ans);
	}
	
	static int getMax(String s) {
		int j = 0, max = 0;
		int len = s.length();
		int[] pi = new int[len];
		
		for (int i = 1; i < len; i++) {
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = pi[j - 1];
			}
			
			if (s.charAt(i) == s.charAt(j)) {
				max = Math.max(max, pi[i] = ++j);
			}
		}
		
		return max;
	}
}
