package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2170 {
	
	static class Pair implements Comparable<Pair> {
		int start;
		int end;
		
		Pair (int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Pair o) {
			if (start == o.start) return end - o.end;
			return start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Pair[] points = new Pair[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(points);
		
		int idx = 0;
		int dist = 0;
		
		while (idx < N) {
			int start = points[idx].start;
			int end = points[idx].end;
			
			while (++idx < N) {
				if (points[idx].start <= end) end = Math.max(end, points[idx].end);
				else break;
			}
			
			dist += (end - start);
		}
		
		System.out.println(dist);
	}

}
