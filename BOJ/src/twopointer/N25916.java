package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N25916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (arr[i] == M) {
				System.out.println(M);
				return;
			}
		}
		
		int ans = 0;
		int sum = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			
			while (sum > M) {
				sum -= arr[idx++];
			}
			
			ans = Math.max(ans, sum);
			
			if (ans == M) {
				System.out.println(M);
				return;
			}
		}
		
		System.out.println(ans);
	}
}
