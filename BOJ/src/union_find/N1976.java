package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1976 {
	
	static int N, M;
	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		init();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int head = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < M; i++) {
			if (!isConnected(head, Integer.parseInt(st.nextToken()))) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return find(parents[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		parents[x] = parents[y] = Math.min(x, y);
	}
	
	static boolean isConnected(int x, int y) {
		return find(x) == find(y);
	}

	static void init() {
		parents = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}
