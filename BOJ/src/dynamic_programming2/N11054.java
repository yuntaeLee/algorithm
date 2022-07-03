package dynamic_programming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11054 {
	
	static int N;
	
	static int[] seq;
	static int[] lis;
	static int[] lds;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		lis = new int[N];
		lds = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS();
		LDS();
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, lis[i] + lds[i]);
		}
		
		System.out.println(ans - 1);
	}
	
	static void LIS() {
		for (int i = 0; i < N; i++) {
			lis[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if (seq[j] < seq[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
	}
	
	static void LDS() {
		for (int i = N - 1; i >= 0; i--) {
			lds[i] = 1;
			
			for (int j = N - 1; j > i; j--) {
				if (seq[j] < seq[i] && lds[i] < lds[j] + 1) {
					lds[i] = lds[j] + 1;
				}
			}
		}
	}
}
