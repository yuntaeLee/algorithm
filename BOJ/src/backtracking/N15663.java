package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class N15663 {
	
	static int N, M;
	static int[] arr, result;
	static boolean[] visited;
	static LinkedHashSet<String> ans = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		backTracking(0);
		
		for (String s : ans) {
			sb.append(s).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void backTracking(int cnt) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			
			for (int val : result) {
				sb.append(val).append(' ');
			}
			ans.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			result[cnt] = arr[i];
			backTracking(cnt + 1);
			visited[i] = false;
		}
	}

}
