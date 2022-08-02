package divde_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2448 {
	
	static StringBuilder sb = new StringBuilder();
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new String[N];
		arr[0] = "  *  ";
		arr[1] = " * * ";
		arr[2] = "*****";
		
		for (int k = 1; (int)Math.pow(2, k) * 3 <= N; k++) {
			divideConquer(k);
		}
		
		sb.delete(0, sb.length());
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void divideConquer(int k) {
		int end = 3 * (int)Math.pow(2, k);
		int mid = end / 2;
		
		for (int i = mid; i < end; i++) {
			arr[i] = arr[i - mid] + " " + arr[i - mid];
		}
		
		while (sb.length() < mid) {
			sb.append(" ");
		}
		
		for (int i = 0; i < mid; i++) {
			arr[i] = sb.toString() + arr[i] + sb.toString();
		}
	}
}
