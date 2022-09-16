package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3584_2 {
	
	static int N;
	static int[] parent;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			visited = new boolean[N + 1];
			
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				parent[B] = A;
			}
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(solution(a, b)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int solution(int a, int b) {
		dfs(a); // a 노드에서 root 노드로 올라가면서 방문 표시
		
		// b 노드에서 최초 방문 표시된 노드 찾기
		while (b != 0) {
			if (visited[b]) break;
			b = parent[b];
		}
		
		return b;
	}
	
	
	static void dfs(int cur) {
		visited[cur] = true;
		
		if (parent[cur] != 0) {
			dfs(parent[cur]);
		}
	}
}
