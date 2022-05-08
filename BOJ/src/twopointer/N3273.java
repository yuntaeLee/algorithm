package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);

		int start = 0;
		int end = N - 1;
		int sum = 0;
		int ans = 0;

		while (start < end) {
			sum = arr[start] + arr[end];

			if (sum == x) ans++;

			if (sum <= x) start++;
			else end--;
		}

		System.out.println(ans);
	}
}
