package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1305 {
	
	static int L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		L = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int[] pi = getPi(arr);
		
		System.out.println(L - pi[L - 1]);
	}
	
	
	static int[] getPi(char[] arr) {
		int[] pi = new int[L];
		int j = 0;
		
		for (int i = 1; i < L; i++) {
			while (j > 0 && arr[i] != arr[j]) {
				j = pi[j - 1];
			}
			
			if (arr[i] == arr[j]) pi[i] = ++j;
		}
		
		return pi;
	}
}
