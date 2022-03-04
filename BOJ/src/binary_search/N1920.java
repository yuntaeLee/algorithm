package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			
			if (binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}
			
			else sb.append(0).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int binarySearch(int[] arr, int key) {
		
		int lo = 0;				 // Ž�� ������ ���� �� �ε�
		int hi = arr.length - 1; // Ž�� ������ ������ �� �ε���
		
		while (lo <= hi) {
			
			int mid = (lo + hi) / 2; // �߰� ��ġ
			
			// key ���� �߰� ��ġ������ ���� ���
			if (key < arr[mid]) {
				hi = mid - 1;
			}
			
			// key ���� �߰� ��ġ������ Ŭ ���
			else if (key > arr[mid]) {
				lo = mid + 1;
			}
			
			// key ���� �߰� ��ġ ���� ���� ���
			else {
				return mid;
			}
		}
		
		// ã���� �ϴ� ���� �������� ���� ���
		return -1;
	}
}
