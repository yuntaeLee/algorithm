package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2577 {
	
	static StringBuilder sb = new StringBuilder();
	
	static void getNumberCounts(int num) {
		int numLength = String.valueOf(num).length();
		int[] counts = new int[10];
		
		for (int i = 0; i < numLength; i++) {
			counts[num % 10]++;
			num /= 10;
		}
		
		for (int n : counts) sb.append(n).append('\n');
		
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 1;
		for (int i = 0; i < 3; i++) {
			num *= Integer.parseInt(br.readLine());
		}
		
		getNumberCounts(num);
		
		br.close();
	}
}
