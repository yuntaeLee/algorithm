package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2473 {
	
	static int N;
	static long[] ans = new long[3];
	static long max = 3000000000L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N - 2; i++) {
			solution(arr, i);
		}
		
		for (long val : ans) {
			sb.append(val).append(' ');
		}
		
		System.out.println(sb);
	}
	
	static void solution(long[] arr, int idx) {
		int left = idx + 1;
		int right = N - 1;
		
		while (left < right) {
			long sum = arr[left] + arr[right] + arr[idx];
			long absSum = Math.abs(sum);
			
			if (absSum < max) {
				ans[0] = arr[idx];
				ans[1] = arr[left];
				ans[2] = arr[right];
				max = absSum;
			}
			
			if (sum > 0) right--;
			else left++;
		}
	}
}
