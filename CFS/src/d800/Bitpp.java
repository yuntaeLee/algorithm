package d800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bitpp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		
		while (n-- > 0) {
			String s = br.readLine();
			
			if (s.charAt(0) == '+') ans++;
			else if (s.charAt(0) == '-') ans--;
			else {
				if (s.charAt(1) == '+') ans++;
				else ans--;
			}
		}
		
		System.out.println(ans);
	}
}
