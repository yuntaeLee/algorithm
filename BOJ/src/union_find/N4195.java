package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N4195 {
	
	static int[] parent;
	static int[] level;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[F * 2];
			level = new int[F * 2];
			
			init();
			
			int idx = 0;
			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				
				if (!map.containsKey(f1)) {
					map.put(f1, idx++);
				}
				
				if (!map.containsKey(f2)) {
					map.put(f2, idx++);
				}
				
				sb.append(union(map.get(f1), map.get(f2))).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static void init() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			level[i] = 1;
		}
	}
	
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static int union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x;
			level[x] += level[y];
			level[y] = 1;
		}
		
		return level[x];
	}
}
