package sogang_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken()) - 1;
		long M = Long.parseLong(st.nextToken()) + 1;
		
		if (N % M == 0) System.out.println("Can't win");
		else System.out.println("Can win");
	}
}
