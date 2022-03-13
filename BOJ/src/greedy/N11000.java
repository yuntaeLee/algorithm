package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N11000 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (int[] i1, int[] i2) -> {
			if (i1[0] == i2[0]) return i1[1] - i2[1];
			return i1[0] - i2[0];
		});
		
		pq.offer(arr[0][1]);
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= arr[i][0]) pq.poll();
			pq.offer(arr[i][1]);
		}
		
		System.out.println(pq.size());
	}
}