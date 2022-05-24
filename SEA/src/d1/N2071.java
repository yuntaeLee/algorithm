package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2071 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			double sum = 0;
			
			for (int j = 0; j < 10; j++) {
				sum += Double.parseDouble(st.nextToken());
			}
			
			sb.append('#').append(i).append(' ').append(Math.round(sum / 10)).append('\n');
		}
		
		System.out.println(sb);
	}

}
