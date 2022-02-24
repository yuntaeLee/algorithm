package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1003 {
	
	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dp[0][0] = 1;	// N = 0 �� ��, 0�� ȣ�� Ƚ��
		dp[0][1] = 0;	// N = 0 �� ��, 1�� ȣ�� Ƚ��
		dp[1][0] = 0;	// N = 1 �� ��, 0�� ȣ�� Ƚ��
		dp[1][1] = 1;	// N = 1 �� ��, 1�� ȣ�� Ƚ��
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			
			sb.append(dp[N][0]).append(' ').append(dp[N][1]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static Integer[] fibo(int N) {
		// N�� ���� 0, 1�� ȣ�� Ƚ���� ���� ��(Ž������ ���� ���� ��)
		if (dp[N][0] == null || dp[N][1] == null) {
			
			// �� N�� ���� 0 ȣ�� Ƚ���� 1 ȣ�� Ƚ���� ���ȣ��
			dp[N][0] = fibo(N - 1)[0] + fibo(N - 2)[0];
			dp[N][1] = fibo(N - 1)[1] + fibo(N - 2)[1];
		}
		
		return dp[N];
	}

}
