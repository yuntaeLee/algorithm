package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N12904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder S = new StringBuilder(br.readLine());
		StringBuilder T = new StringBuilder(br.readLine());
		
		while (S.length() != T.length()) {
			
			if (T.charAt(T.length() - 1) == 'A') {
				T.deleteCharAt(T.length() - 1);
			}
			
			else {
				T.deleteCharAt(T.length() - 1);
				T.reverse();
			}
		}

		System.out.println(T.toString().equals(S.toString()) ? 1 : 0);
	}
}
