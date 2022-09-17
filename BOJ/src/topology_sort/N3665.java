package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3665 {
	
	static int N;
	static int[] inDegree;
	static boolean[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			inDegree = new int[N + 1];
			arr = new boolean[N + 1][N + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				inDegree[n] = i; // 진입 차수 = 등수
				
				for (int j = 1; j <= N; j++) {
					// 관련 간선이 없다면 만들기
					if (j != n && !arr[j][n]) arr[n][j] = true;
				}
			}
			
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				swap(a, b);
			}
			
			ans.append(topologySort()).append('\n');
		}
		
		System.out.println(ans);
	}
	
	static void swap(int a, int b) {
		// a -> b == false --> a보다 b순위가 더 낮음 : 높아져야 함
		if (!arr[a][b]) {
			arr[a][b] = true;
			arr[b][a] = false;
			inDegree[a]--;
			inDegree[b]++;
		}
		
		// a -> b == true --> a보다 b순위가 더 높음 : 낮아져야 함
		else {
			arr[a][b] = false;
			arr[b][a] = true;
			inDegree[a]++;
			inDegree[b]--;
		}
	}
	
	static String topologySort() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) q.offer(i);
		}
		
		for (int i = 1; i <= N; i++) {
			// 사이클 발생 = IMPOSSIBLE
			if (q.isEmpty()) return "IMPOSSIBLE";
			
			// 이동할 수 있는 정점이 2개 이상 == 나올 수 있는 순위가 여러 개
			else if (q.size() > 1) return "?";
			
			int cur = q.poll();
			sb.append(cur).append(' ');
			
			for (int j = 1; j <= N; j++) {
				// 이동할 수 있는 정점
				if (arr[cur][j]) {
					arr[cur][j] = false; // 이동함
					
					// 진입 차수 줄여주고 0이면 이동
					if (--inDegree[j] == 0) q.offer(j);
				}
			}
		}
		
		return sb.toString();
	}
}
