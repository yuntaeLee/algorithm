package sogang_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int NM = Integer.max(N, M);
		
		int[] present = new int[NM];
		int[] past = new int[NM];
		
		present = getArray(present, N);
		past = getArray(past, M);
		
		int max = 0;
		for (int i = 0; i < NM; i++) {
			if (past[i] - present[i] > max) {
				max = past[i] - present[i];
			}
		}
		
		System.out.println(max);
	}
	
	static int[] getArray(int[] arr, int N) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		return arr;
	}
}
