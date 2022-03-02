package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.RecursiveAction;

public class N1912_2 {

	static int[] arr;
	static Integer[] dp;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		dp = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = dp[0] = arr[0];
	
		// dp의 마지막 index는 n-1이므로 n-1부터 Top-Down 탐색
		recur(n - 1);
		
		System.out.println(max);
	}
	
	static int recur(int n) {
		
		// 탐색하지 않은 인덱스
		if (dp[n] == null) {
			dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);
		
			max = (dp[n] > max) ? dp[n] : max;
		}
		
		return dp[n];
	}

}
