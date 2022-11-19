package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> minPq = new PriorityQueue<>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if (minPq.size() == maxPq.size()) maxPq.offer(n);
			else minPq.offer(n);
			
			if (!minPq.isEmpty() && minPq.peek() < maxPq.peek()) {
				maxPq.offer(minPq.poll());
				minPq.offer(maxPq.poll());
			}
			
			sb.append(maxPq.peek()).append('\n');
		}
		
		System.out.println(sb);
	}
}
