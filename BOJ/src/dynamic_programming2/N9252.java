package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N9252 {
	
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		sb.append(LCS2(s1, s2)).append('\n');
		getLCS(s1, s1.length(), s2.length());
		
		System.out.println(sb);
	}
	
	static int LCS2 (String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		dp = new int[len1 + 1][len2 + 1];
		
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		return dp[len1][len2];
	}
	
	static void getLCS(String s, int i, int j) {
		Stack<Character> stk = new Stack<>();
		
		while (i > 0 && j > 0) {
			
			if (dp[i][j] == dp[i - 1][j]) i--;
			else if (dp[i][j] == dp[i][j - 1]) j--;
			else {
				stk.push(s.charAt(i - 1));
				i--;
				j--;
			}
		}
		
		while (!stk.isEmpty()) {
			sb.append(stk.pop());
		}
	}
}
