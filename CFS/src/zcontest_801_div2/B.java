package zcontest_801_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			if (n % 2 == 0) {
				int min = Integer.MAX_VALUE;
				int temp = 0;
				
				for (int i = 0; i < n; i++) {
					if (min > arr[i]) {
						min = arr[i];
						temp = i;
					}
				}
				
				if (temp % 2 == 0) sb.append("Joe").append('\n');
				else sb.append("Mike").append('\n');
			}
			
			else sb.append("Mike").append('\n');
		}
		
		System.out.println(sb);
	}
}
