package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16198 {
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bt(arr, visited, 0, N);
		
		System.out.println(ans);
	}
	
	static void bt(int[] arr, boolean[] visited, int sum, int n) {
		if (n == 2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int i = 1; i < arr.length - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int left = i - 1;
				int right = i + 1;
				
				while (visited[left] || visited[right]) {
					if (visited[left]) left--;
					if (visited[right]) right++;
				}
				
				int num = arr[left] * arr[right];
				bt(arr, visited, sum + num, n - 1);
				visited[i] = false;
			}
		}
	}
}
