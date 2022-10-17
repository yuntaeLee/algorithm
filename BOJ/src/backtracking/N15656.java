package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15656 {
	
	static int N, M;
	static int[] arr, ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		bt(0);
		
		System.out.println(sb);
	}
	
	static void bt(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i]).append(' ');
			}
			
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			ans[depth] = arr[i];
			bt(depth + 1);
		}
	}
}