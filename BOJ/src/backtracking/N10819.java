package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10819 {
	
	static int N, ans;
	static int[] arr, temp;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		temp = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bt(0);
		
		System.out.println(ans);
	}
	
	static void bt(int depth) {
		if (depth == N) {
			
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(temp[i] - temp[i + 1]);
			}
			
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = arr[i];
				bt(depth + 1);
				visited[i] = false;
			}
		}
	}
}
