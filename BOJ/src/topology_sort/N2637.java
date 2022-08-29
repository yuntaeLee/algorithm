package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2637 {
	
	static class Product {
		int n;
		int cnt;
		
		Product(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
	
	static int[] inDegree;
	static boolean[] isMiddle;
	static ArrayList<ArrayList<Product>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		inDegree = new int[N + 1];
		isMiddle = new boolean[N + 1];
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(new Product(y, k));
			inDegree[y]++;
			isMiddle[x] = true;
		}
		
		int[] ans = topologySort(N);
		
		for (int i = 1; i <= N; i++) {
			if (!isMiddle[i]) {
				sb.append(i).append(' ').append(ans[i]).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static int[] topologySort(int n) {
		Queue<Product> q = new LinkedList<>();
		int[] ans = new int[n + 1];
		
		q.offer(new Product(n, 1));
		ans[n] = 1;
		
		while (!q.isEmpty()) {
			Product cur = q.poll();
			
			for (Product next : graph.get(cur.n)) {
				ans[next.n] += ans[cur.n] * next.cnt;
				
				if (--inDegree[next.n] == 0) q.offer(new Product(next.n, ans[next.n]));
			}
		}
		
		return ans;
	}
}
