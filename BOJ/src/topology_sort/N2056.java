package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2056 {
	
	static int N;
	static int[] inDegree;
	static int[] time;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		inDegree = new int[N + 1];
		time = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				graph.get(temp).add(i);
				
				inDegree[i]++;
			}
		}
		
		System.out.println(topologySort());
	}
	
	static int topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			result[i] = time[i];
			
			if (inDegree[i] == 0) q.offer(i);
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph.get(cur)) {
				result[next] = Math.max(result[next], result[cur] + time[next]);
				
				if (--inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, result[i]);
		}
		
		return ans;
	}
}
