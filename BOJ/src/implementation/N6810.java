package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N6810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int ans = 91;
		int[] mul = {1, 3};
		
		for (int i = 0; i < 3; i++) {
			ans += Integer.parseInt(br.readLine()) * mul[i % 2];
		}
		
		sb.append("The 1-3-sum is ").append(ans);
		System.out.println(sb);
	}
	
}
