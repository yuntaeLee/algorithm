package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6603 {
	
	static int n;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		while (n != 0) {
			arr = new int[n];
			visited = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			bt(0, 0);
			sb.append('\n');
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb);
	}
	
	static void bt(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sb.append(arr[i]).append(' ');
				}
			}
			
			sb.append('\n');
			return;
		}
		
		for (int i = start; i < n; i++) {
			visited[i] = true;
			bt(i + 1, depth + 1);
			visited[i] = false;
		}
	}
}
