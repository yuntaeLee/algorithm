package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2455 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int ans = 0;
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			sum += -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
}
