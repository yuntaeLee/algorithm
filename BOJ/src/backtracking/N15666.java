package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15666 {
	
	static int N, M;
	static int[] arr, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		backTracking(0, 0, sb);
		
		System.out.println(sb);
	}
	
	static void backTracking(int start, int cnt, StringBuilder sb) {
		if (cnt == M) {
			for (int val : result) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
		}
		
		else {
			int num = 0;
			for (int i = start; i < N; i++) {
				if (num == arr[i]) continue;
				
				result[cnt] = arr[i];
				backTracking(i, cnt + 1, sb);
				num = arr[i];
			}
		}
	}

}
