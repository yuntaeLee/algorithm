package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[9];
		int sum = 0;
		int p1 = 0, p2 = 0;
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					p1 = i;
					p2 = j;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (i == p1 || i == p2) continue;
			sb.append(arr[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}
