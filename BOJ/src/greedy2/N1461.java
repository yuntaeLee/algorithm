package greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans = 0;
		int max = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> positive = new PriorityQueue<>((p1, p2) -> p2 - p1);
		PriorityQueue<Integer> negative = new PriorityQueue<>((p1, p2) -> p2 - p1);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n > 0) positive.offer(n);
			else negative.offer(Math.abs(n));
		}
		
		if (positive.isEmpty()) max = negative.peek();
		else if (negative.isEmpty()) max = positive.peek();
		else max = Math.max(positive.peek(), negative.peek());
		
		while (!positive.isEmpty()) {
			int n = positive.poll();
			for (int i = 0; i < M - 1; i++) {
				positive.poll();
				if (positive.isEmpty()) break;
			}
			
			ans += n * 2;
		}
		
		while (!negative.isEmpty()) {
			int n = negative.poll();
			for (int i = 0; i < M - 1; i++) {
				negative.poll();
				if (negative.isEmpty()) break;
			}
			
			ans += n * 2;
		}
		
		System.out.println(ans - max);
	}
}
