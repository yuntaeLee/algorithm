package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {

			int k = Integer.parseInt(br.readLine());
			
			Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Integer> min = new PriorityQueue<>();
			Map<Integer, Integer> map = new HashMap<>();
			
			while (k-- > 0) {
				
				st = new StringTokenizer(br.readLine(), " ");
				String s = st.nextToken(); 
				int n = Integer.parseInt(st.nextToken());
				
				if (s.equals("I")) {
					max.offer(n);
					min.offer(n);
					
					map.put(n, map.getOrDefault(n, 0) + 1);
				}
					
				else {
					if (map.size() == 0) continue;
					
					if (n == 1) delete(max, map);
					else delete(min, map);
				}	
			}
			
			if (map.size() == 0) sb.append("EMPTY").append('\n');
			else {
				int res = delete(max, map);
				sb.append(res).append(' ');
				
				if (map.size() > 0) res = delete(min, map);
				sb.append(res).append('\n');
			}
		}
		System.out.println(sb);	
	}
	
	static int delete(Queue<Integer> q, Map<Integer, Integer> map) {
		
		int res = 0;
		
		while (true) {
			res = q.poll();
			
			int cnt = map.getOrDefault(res, 0);
			if (cnt == 0) continue; 
			
			if (cnt == 1) map.remove(res);
			else map.put(res, cnt - 1);
			break;
		}
		
		return res;
	}
}
