package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N15829 {
	
	static final int m = 1234567891;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long hash = 0;
		double r = 1;
		
		for (int i = 0; i < n; i++) {
			hash += (str.charAt(i) - 96) * r;
			r = r * 31 % m;
		}
		
		System.out.println(hash % m);
		
	}

}
