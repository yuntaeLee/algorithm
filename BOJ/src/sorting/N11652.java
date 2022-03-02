package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N11652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int max = 1;
		int count = 1;
		long temp = arr[0];
		
		for (int i = 1; i < N; i++) {
			
			if (arr[i] == arr[i - 1]) count++;
			else count = 1;
			
			if (count > max) {
				max = count;
				temp = arr[i];
			}
		}
		
		System.out.println(temp);
	}
}
