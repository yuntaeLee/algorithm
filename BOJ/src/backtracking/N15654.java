package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15654 {
	
	static int N, M;
	
	static int[] ans;
	static int[] arr;
	
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		arr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		if (start == M) {
			for (int i = 0; i < ans.length; i++) {
				sb.append(ans[i]).append(' ');
			}
			
			sb.append('\n');
			return;
		} 
			
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			ans[start] = arr[i];
			dfs(start + 1);
			visited[i] = false;
		}
	}
}
