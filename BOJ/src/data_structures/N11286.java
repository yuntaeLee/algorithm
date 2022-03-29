package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> {
			if (Math.abs(a1) == Math.abs(a2)) return a1 - a2;
			return Math.abs(a1) - Math.abs(a2);	
		});
		
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				if (pq.isEmpty()) sb.append(0).append('\n');
				else sb.append(pq.poll()).append('\n');
			}
			
			else pq.offer(x);
		}
		
		System.out.println(sb);
	}
}
