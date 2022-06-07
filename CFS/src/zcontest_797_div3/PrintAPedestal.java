package zcontest_797_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAPedestal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int base = n / 3;
			
			if (n % 3 == 0) {
				sb.append(base).append(' ')
				  .append(base + 1).append(' ')
				  .append(base - 1).append('\n');
			} else if (n % 3 == 1) {
				sb.append(base).append(' ')
				  .append(base + 2).append(' ')
				  .append(base - 1).append('\n');
			} else {
				sb.append(base + 1).append(' ')
				  .append(base + 2).append(' ')
				  .append(base - 1).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}
