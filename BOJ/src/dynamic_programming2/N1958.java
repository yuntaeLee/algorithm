package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1958 {
	
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		
		System.out.println(LCS3(s1, s2, s3));
	}
	
	static int LCS3(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		
		dp = new int[len1 + 1][len2 + 1][len3 + 1];
		
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				for (int k = 1; k <= len3; k++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1))
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					else
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
				}
			}
		}
		
		return dp[len1][len2][len3];
	}
}
