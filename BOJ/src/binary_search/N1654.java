package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(lanCableLength(arr, 1, max + 1, N));
	}
	
	static long lanCableLength(int[] arr, long min, long max, int N) {
		
		while (min < max) {
			
			long mid = (max + min) / 2;
			long count = 0;
			
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			
			/**
			 * [uper bound]
			 * 
			 * mid ���̷� �߶��� ���� ������ ������� �ϴ� ������ �������� �۴ٸ�
			 * �ڸ����� �ϴ� ���̸� ���̱� ���� �ִ� ���̸� ���δ�.
			 * �� �ܿ��� �ڸ����� �ϴ� ���̸� �÷��� �ϹǷ� �ּ� ���̸� �ø���.
			 */
			if (count < N) max = mid;
			else min = mid + 1;
		}
		
		return min - 1;
	}
}
