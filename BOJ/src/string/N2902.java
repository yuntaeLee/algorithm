package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2902 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		sb.append(s.charAt(0));
		
		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == '-') sb.append(s.charAt(i + 1));
		}
		
		System.out.println(sb);
	}

}
