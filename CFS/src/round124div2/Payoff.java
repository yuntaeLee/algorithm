package round124div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Payoff {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = (int)Math.pow(2, Integer.parseInt(br.readLine()));
			
			if (n % 2 == 1) sb.append(n).append('\n');
			else sb.append(n - 1).append('\n');
		}
		
		System.out.println(sb);
	}
}
