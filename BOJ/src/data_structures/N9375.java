package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N9375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Map<String, Integer> map = new HashMap<>();
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			
			int N = Integer.parseInt(br.readLine());
			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String kind = st.nextToken();
				
				map.put(kind, map.getOrDefault(kind, 0) + 1);
			}
			
			int ans = 1;
			for (int val : map.values()) {
				ans *= val + 1;
			}
			
			sb.append(ans - 1).append('\n');
			map.clear();
		}
		
		System.out.println(sb);
	}
}
