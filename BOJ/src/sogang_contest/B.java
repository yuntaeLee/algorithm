package sogang_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
	}
	
	static int factorial(int num) {
		if (num == 1) return 1;
		
		return num * factorial(num - 1);
	}
}
