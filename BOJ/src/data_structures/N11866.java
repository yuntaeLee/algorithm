package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append('<');
		int idx = 1;
		while (queue.size() > 1) {
			
			if (idx % M == 0) {
				sb.append(queue.poll()).append(',').append(' ');
				idx++;
			} else {
				queue.offer(queue.poll());
				idx++;
				
			}
			
		}
		
		sb.append(queue.poll()).append('>');
		
		System.out.println(sb);
	}
}
