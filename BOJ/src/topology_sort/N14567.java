package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N14567 {
	
	static int N, M;
	static int[] ans;
	static int[] inDegree;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[N + 1];
		inDegree = new int[N + 1];
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list.get(A).add(B);
			inDegree[B]++;
		}
		
		topologySort();
		
		for (int i = 1; i <= N; i++) {
			sb.append(ans[i]).append(' ');
		}
		
		System.out.println(sb);
	}
	
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
				ans[i] = 1;
				
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : list.get(cur)) {
				
				if (--inDegree[next] == 0) {
					q.offer(next);
					ans[next] = ans[cur] + 1;
				}
			}			
		}
	}
}
