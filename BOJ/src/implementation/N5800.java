package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N5800 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int gap = 0;
			
			for (int i = 0; i < N - 1; i++) {
				gap = Math.max(gap, arr[i + 1] - arr[i]);
			}
			
			sb.append("Class ").append(k).append('\n')
				.append("Max ").append(arr[N - 1]).append(", ")
				.append("Min ").append(arr[0]).append(", ")
				.append("Largest gap ").append(gap).append('\n');
			
		}
		
		System.out.println(sb);
	}
}
