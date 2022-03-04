package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(lanCableLength(arr, 1, max + 1, N));
	}
	
	static long lanCableLength(int[] arr, long min, long max, int N) {
		
		while (min < max) {
			
			long mid = (max + min) / 2;
			long count = 0;
			
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			
			/**
			 * [upper bound]
			 * 
			 * mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
			 * 자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
			 * 그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
			 */
			if (count < N) max = mid;
			else min = mid + 1;
		}
		
		return min - 1;
	}
}
