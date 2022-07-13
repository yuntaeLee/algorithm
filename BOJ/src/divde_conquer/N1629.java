package divde_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1629 {
	
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A, B));
	}
	
	static long pow(long a, long b) {
		
		// 지수가 1일 경우 A^1 이므로 A를 그대로 리털
		if (b == 1) return a % C;
		
		// 지수의 절반에 해당하는 A^(B / 2)을 구한다.
		long n = pow(a, b / 2);
		
		/**
		 * 현재 지수가 홀 수 였다면
		 * A^(B / 2) * A^(B / 2) * A 이므로
		 * A를 한 번 더 곱해주어야 한다.
		 * 
		 * ex) A^9 = A^4 * A^4 * A
		 */
		if (b % 2 == 1) return (n * n % C) * a % C;
		
		return n * n % C;
	}
}
