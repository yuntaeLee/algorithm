package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N2183 {
	
	static int N, M;
	static int[] barn;
	static boolean[] visited;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		barn = new int[M + 1];
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < cnt; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[M + 1];
			if (dfs(i)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static boolean dfs(int cur) {
		for (int next : graph.get(cur)) {
			if (visited[next]) continue;
			visited[next] = true;
			
			if (barn[next] == 0 || dfs(barn[next])) {
				barn[next] = cur;
				return true;
			}
		}
		
		return false;
	}
}
