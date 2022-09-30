package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len1 = br.readLine().length();
		int len2 = br.readLine().length();
		
		System.out.println(len1 >= len2 ? "go" : "no");
	}

}
