package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1083 {
	
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int S = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N && 0 < S; i++) {
			int max = -1;
			int maxIdx = -1;
			
			for (int j = i; j < N && j <= i + S; j++) {
				if (max < A[j]) {
					max = A[j];
					maxIdx = j;
				}
			}
			
			for (int j = maxIdx; j > i; j--) {
				swap(j - 1, j);
				S--;
			}
		}
		
		for (int i : A) sb.append(i).append(' ');
		System.out.println(sb);		
	}
	
	static void swap(int i, int j) {
		int temp = A[i];
		
		A[i] = A[j];
		A[j] = temp;
	}
}
