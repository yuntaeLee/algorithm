package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9466 {
	
	static int n;
	static int count;
	static int[] arr;
	static boolean[] visited;
	static boolean[] finished;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			count = 0;
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				dfs(i);
			}
			
			sb.append(n - count).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		if (visited[start]) return;
		
		visited[start] = true;
		int next = arr[start];
		
		if (!visited[next]) 
			dfs(next);
		
		else {
			
			if (!finished[next]) {
				count++;
				
				for (int i = next; i != start; i = arr[i]) {
					count++;
				}
			}
		}
		
		finished[start] = true;
	}

}
