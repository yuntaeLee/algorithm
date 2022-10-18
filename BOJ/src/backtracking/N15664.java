package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N15664 {
	
	static int N, M;
	static int[] arr, ans;
	static boolean[] visited;
	static Set<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		bt(0, 0);
		
		System.out.println(sb);
	}
	
	static void bt(int start, int depth) {
		if (depth == M) {
			StringBuilder temp = new StringBuilder();
			
			for (int i = 0; i < M; i++) {
				temp.append(ans[i]).append(' ');
			}
			
			if (!set.contains(temp.toString())) {
				set.add(temp.toString());
				sb.append(temp).append('\n');
			}
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans[depth] = arr[i];
				bt(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
}
