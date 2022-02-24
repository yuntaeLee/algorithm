package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11726 {
	static int[] d = new int[1001];
	
	static int dp(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (d[n] != 0) return d[n];
		
		return d[n] = (dp(n - 1) + dp(n - 2)) % 10007;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		System.out.println(dp(n));
	}
}
