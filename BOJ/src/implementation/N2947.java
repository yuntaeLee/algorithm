package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2947 {
	
	static int[] arr = new int[5];
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while (!isSorted()) {
			for (int i = 0; i < 4; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(i, i + 1);
					print();
				}
			}
		}
		
		System.out.println(sb);
	}
	
	static void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	static boolean isSorted() {
		for (int i = 0; i < 5; i++) {
			if (arr[i] != i + 1) {
				return false;
			}
		}
		
		return true;
	}
	
	static void print() {
		for (int i = 0; i < 5; i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.append('\n');
	}
}
