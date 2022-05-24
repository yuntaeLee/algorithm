package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N13428 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			String s = br.readLine();
			char[] arr = s.toCharArray();
			
			int min = Integer.parseInt(s);
			int max = min;
			
			for (int x = 0; x < arr.length - 1; x++) {
				for (int y = x + 1; y < arr.length; y++) {
					swap(x, y, arr);
					
					int n = Integer.parseInt(String.valueOf(arr));
					if (arr[0] != '0' && n < min) {
						min = n;
					}
					
					if (arr[0] != '0' && n > max) {
						max = n;
					}
					
					swap(x, y, arr);
				}
			}
			
			sb.append('#').append(i).append(' ').append(min).append(' ').append(max).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void swap(int x, int y, char[] arr) {
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
