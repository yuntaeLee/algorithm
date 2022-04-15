package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class N9237 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			result = Math.max(result, arr[i] + i + 1);
		}
		
		System.out.println(result + 1);
	}
}
