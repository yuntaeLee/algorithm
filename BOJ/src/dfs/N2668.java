package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N2668 {

	static int N, num;
	static int[] map;
	static boolean[] visited;
	static List<Integer> ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1];
		ans = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			num = i;
			dfs(i);
		}
		
		Collections.sort(ans);
		
		sb.append(ans.size()).append('\n');
		for (int val : ans) {
			sb.append(val).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		if (map[start] == num) ans.add(num); 
		
		int next = map[start];
		
		if (!visited[next]) {
			visited[next] = true;
			dfs(next);
		}
	}
}
