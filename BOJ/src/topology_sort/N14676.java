package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N14676 {
	
	static int n;
	static int[] inDegree;
	static int[] buildCnt;
	static List<List<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		inDegree = new int[n + 1];
		buildCnt = new int[n + 1];
		
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			inDegree[y]++;
		}
		
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			boolean isBuild = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			int cur = Integer.parseInt(st.nextToken());
			
			if ((isBuild && inDegree[cur] != 0) || (!isBuild && buildCnt[cur] == 0)) {
				System.out.println("Lier!");
				return;
			}
			
			if (isBuild) {
				buildCnt[cur]++;
				
				if (buildCnt[cur] == 1) {
					for (int next : graph.get(cur)) {
						inDegree[next]--;
					}
				}
			}
			
			else {
				buildCnt[cur]--;
				
				if (buildCnt[cur] == 0) {
					for (int next: graph.get(cur)) {
						inDegree[next]++;
					}
				}
			}
		}
		
		System.out.println("King-God-Emperor");
	}
}
