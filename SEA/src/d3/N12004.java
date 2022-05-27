package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N12004 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append('#').append(t).append(' ').append(isPossible(n)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static String isPossible(int n) {
		for (int i = 1; i < 10; i++) {
			if (n % i == 0 && n / i >= 1 && n / i <= 9) return "Yes";
		}
		
		return "No";
	}

}
