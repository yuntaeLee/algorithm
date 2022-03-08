package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N7662_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			while (k-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String op = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if (op.equals("I")) map.put(n, map.getOrDefault(n, 0) + 1);
				
				else {
					if (map.isEmpty()) continue;
					
					int target = (n == 1) ? map.lastKey() : map.firstKey();
					
					if (map.get(target) > 1) map.put(target, map.get(target) - 1);
					else map.remove(target);
				}
			}
			
			if (map.isEmpty()) sb.append("EMPTY").append('\n');
			else sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
		}
		
		System.out.println(sb);
	}
}
