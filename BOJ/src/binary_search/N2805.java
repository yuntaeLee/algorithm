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
		
		// �̺�Ž�� (upper bound)
		while (min < max) {
			
			int mid = (min + max) / 2;
			long sum = 0;
			
			for (int tree : trees) {
				
				if (tree - mid > 0) {
					sum += (tree - mid);
				}
			}
			/*
			 * �ڸ� ���� ������ ���� M���� �۴ٴ� ����
			 * �ڸ��� ��ġ(����)�� ���ٴ� �ǹ��̹Ƿ� ���̸� ����� �Ѵ�.
			 */
			if (sum < M) max = mid;
			
			/*
			 * �ڸ��� ���� ������ ���� M���� ũ�ٴ� ����
			 * �ڸ��� ��ġ(����)�� ���ٴ� �ǹ��̹Ƿ� ���̸� ������ �Ѵ�.
			 */
			else min = mid + 1;
		}
		
		return min - 1;
	}
}
