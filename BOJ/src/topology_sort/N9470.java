package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9470 {
	
	static int K, M, P;
	static int[] inDegree, order, cnt;
	static ArrayList<ArrayList<Integer>> graph;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			
			inDegree = new int[M + 1]; // 진입 차수
			order = new int[M + 1];    // 진입 순서
			cnt = new int[M + 1];      // 강의 수
			
			graph = new ArrayList<>();
			for (int i = 0; i <= M; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				graph.get(A).add(B);
				inDegree[B]++;
			}
			
			topologySort();
		}
		
		System.out.println(sb);
	}
	
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= M; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
				order[i]++; // 강의 근원 = 1
				cnt[i]++;
			}
		}
		
		int ans = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if (cnt[cur] >= 2) order[cur]++; // 들어오는 강이 2개 이상이면 순서 증가
			ans = Math.max(ans, order[cur]);
			
			for (int next : graph.get(cur)) {
				if (--inDegree[next] == 0) q.offer(next);
				
				// 동일 순서에서 추가 방문
				if (order[cur] == order[next]) cnt[next]++;
				
				// Strahler 순서는 들어오는 순서 중 최댓값
				else if (order[next] < order[cur]) {
					order[next] = order[cur];
					cnt[next] = 1;
				}
			}
		}
		
		sb.append(K).append(' ').append(ans).append('\n');
	}
}
