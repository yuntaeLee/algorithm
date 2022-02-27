package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11053_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;	// �迭�� �ּұ��� = 1
			
			// 0 ~ i ���� ���ҵ� Ž��
			for (int j = 0; j < i; j++) {
				
				// j��° ���Ұ� i��° ���Һ��� �����鼭 i��° dp�� j ��° dp+1 ������ �������
				if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;	// j��° ������ +1 ���� i��° dp�� �ȴ�.
				}
			}
		}
		
		// �ִ� Ž��
		int max = dp[0];
		for (int i = 1; i < N; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		
		System.out.println(max);
	}

}
