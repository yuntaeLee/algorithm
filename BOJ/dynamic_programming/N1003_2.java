package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1003_2 {
	
	static int zero;
	static int one;
	static int zeroPlusOne;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			fibo(Integer.parseInt(br.readLine()));
			
			sb.append(zero).append(' ').append(one).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void fibo(int N) {
		zero = 1;
		one = 0;
		zeroPlusOne = 1;
	
		for (int i = 0; i < N; i++) {
			zero = one;
			one = zeroPlusOne;
			zeroPlusOne = zero + one;
		}
	}

}
