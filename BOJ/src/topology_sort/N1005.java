package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1005 {
	
	static int N, K, W;
	
	static int[] inDegree;
	static int[] cost;
	
	static ArrayList<ArrayList<Integer>> list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			inDegree = new int[N + 1];
			cost = new int[N + 1];
			list = new ArrayList<>();
			
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.get(x).add(y);
				inDegree[y]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			topologySort();
		}
		
		System.out.println(sb);
	}
	
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N + 1];
		
		// 건물의 기본 소요시간 d[i]
		for (int i = 1; i <= N; i++) {
			result[i] = cost[i];
			
			if (inDegree[i] == 0) q.offer(i);
		}
		
		// 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
		// 이전 테크가 다 올라가야 현재 건물을 지을 수 있기 때문에 Max
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : list.get(cur)) {
				result[next] = Math.max(result[next], result[cur] + cost[next]);
				
				if (--inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		sb.append(result[W]).append('\n');
	}
}
