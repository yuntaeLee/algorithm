package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N25304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			x -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		}
		
		System.out.println(x == 0 ? "Yes" : "No");
	}
}
