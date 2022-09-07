package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N14916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int ans = 0;
		while (n > 0) {
			
			if (n % 5 == 0) {
				ans += n / 5 ;
				break;
			}
			
			n -= 2;
			ans++;
		}
		
		System.out.println(n < 0 ? -1 : ans);
	}
}
