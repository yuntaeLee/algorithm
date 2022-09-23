package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N24060 {
	
	static int ans = -1;
	static int N, K;
	static int count;
	static int[] arr, temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		temp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, 0, N - 1);
		
		System.out.println(ans);
	}
	
	static void mergeSort(int[] arr, int p, int r) {
		if (count > K) return;
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}
	
	static void merge(int[] arr, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				i++;
			}
			else {
				temp[t] = arr[j];
				j++;
			}
			t++;
		}
		
		while (i <= q) temp[t++] = arr[i++];
		while (j <= r) temp[t++] = arr[j++];
		
		i = p;
		t = 0;
		while (i <= r) {
			count++;
			
			if (count == K) {
				ans = temp[t];
				break;
			}
			
			arr[i++] = temp[t++];
		}
	}
}
