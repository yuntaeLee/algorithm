package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N5525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		int ans = 0;
		int pattern = 0;
		
		for (int i = 1; i < M - 1; i++) {
			if (arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
				pattern++;
				i++;
				
				if (pattern == N) {
					pattern--;
					ans++;
				}
			} else {
				pattern = 0;
			}
		}
		
		System.out.println(ans);
	}

}
