package greedy2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N16225 {
	
	static class Pair implements Comparable<Pair> {
		int a;
		int b;
		
		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Pair o) {
			return b - o.b;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer a = new StringTokenizer(br.readLine());
		StringTokenizer b = new StringTokenizer(br.readLine());
		
		PriorityQueue<Pair> pairQ = new PriorityQueue<>();
		for (int i = 0; i < n ; i++) {
			pairQ.offer(new Pair(Integer.parseInt(a.nextToken()), Integer.parseInt(b.nextToken())));
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		long ans = pairQ.poll().a;
		for (int i = 1; i < n - 1; i += 2) {
			pq.offer(pairQ.poll().a);
			pq.offer(pairQ.poll().a);
			
			ans += pq.poll();
		}
		
		System.out.println(ans);
	}
}
