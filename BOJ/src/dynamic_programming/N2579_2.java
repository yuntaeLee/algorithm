package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2579_2 {
	
	static Integer[] dp;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1];
		arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];	// default value가 null이기 때문에 초기화
		dp[1] = arr[1];
		
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		System.out.println(find(N));
	}
	
	static int find(int N) {
		
		// 탐색하지 않은 N번째 계단일 경우
		if (dp[N] == null) {
			dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
		}
		
		return dp[N];
	}

}
