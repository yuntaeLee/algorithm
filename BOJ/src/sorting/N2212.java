package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class N2212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		if (K >= N) {
			System.out.println(0);
			return;
		}
		
		int ans = 0;
		int[] arr = new int[N];
		Integer[] sub = new Integer[N - 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N - 1; i++) {
			sub[i] = arr[i + 1] - arr[i];
		}
		
		Arrays.sort(sub, Collections.reverseOrder());
		
		for (int i = K - 1; i < N - 1; i++) {
			ans += sub[i];
		}
		
		System.out.println(ans);
	}
}
