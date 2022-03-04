package binary_search;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class N2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		System.out.println(cutTree(trees, 0, max, M));
	}
	
	static int cutTree(int[] trees, int min, int max, int M) {
		
		// Upper bound
		while (min < max) {
			
			int mid = (min + max) / 2;
			long sum = 0;
			
			for (int tree : trees) {
				
				if (tree - mid > 0) {
					sum += (tree - mid);
				}
			}
			/*
			 * 자른 나무 길이의 합이 M보다 작다는 것은
			 * 자르는 위치(높이)가 높다는 의미이므로 높이를 낮춰야 한다.
			 */
			if (sum < M) max = mid;
			
			/*
			 * 자르는 나무 길이의 합이 M보다 크다는 것은
			 * 자르는 위치(높이)가 낮다는 의미이므로 높이를 높여야 한다.
			 */
			else min = mid + 1;
		}
		
		return min - 1;
	}
}
