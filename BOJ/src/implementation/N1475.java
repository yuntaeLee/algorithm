package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1475 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] arr = new int[10];
		
		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			
			if (n == 6 || n == 9) {
				
				if (arr[6] < arr[9]) {
					arr[6]++;
				}
				else {
					arr[9]++;
				}
				
				continue;
			}
			
			arr[n]++;
		}
		
		int max = 0;
		for (int i : arr) max = Math.max(max, i);
		
		System.out.println(max);
	}

}
