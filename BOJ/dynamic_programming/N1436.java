package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1436 {
	
	static Integer[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		d = new Integer[x + 1];
		d[0] = d[1] = 0;
		
		System.out.println(dp(x));
	}
	
	static int dp(int x) {
		
		if (d[x] == null) {
			
			if (x % 6 == 0) {
				d[x] = Math.min(dp(x - 1), Math.min(dp(x / 3), dp(x / 2))) + 1;
			}
			
			else if (x % 3 == 0) {
				d[x] = Math.min(dp(x / 3), dp(x - 1)) + 1;
			}
			
			else if (x % 2 == 0) {
				d[x] = Math.min(dp(x / 2), dp(x - 1)) + 1;
			}
			
			else {
				d[x] = dp(x - 1) + 1;
			}
		}
		
		return d[x];
	}
}
