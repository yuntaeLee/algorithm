package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// k = 거쳐가는 노드
		for (int k = 0; k < N; k++) {
			// i = 출발 노드
			for (int i = 0; i < N; i++) {
				// j = 도착 노드
				for (int j = 0; j < N; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}
				}
			}
		}

		
		for (int[] arr : graph) {
			for (int i : arr) sb.append(i).append(' ');
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
