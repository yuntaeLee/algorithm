package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2529 {
	
	static int k;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		char[] sign = new char[k];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		int[] front = new int[10];
		int[] back = new int[10];
		
		for (int i = 0; i < 10; i++) {
			front[i] = i;
			back[9 - i] = i;
		}
		
		bt(0, back, new int[k + 1], sign, new boolean[10]);
		bt(0, front, new int[k + 1], sign, new boolean[10]);
		
		System.out.println(sb);
	}
	
	static boolean bt(int depth, int[] dir, int[] arr, char[] sign, boolean[] v) {
		if (depth == k + 1) {
			for (int i = 0; i <= k; i++) {
				sb.append(arr[i]);
			}
			 
			sb.append('\n');
			return true;
		}
		
		for (int idx = 0; idx < 10; idx++) {
			int i = dir[idx];
			if (v[i]) continue;
			
			if (depth == 0 || compare(arr[depth - 1], sign[depth - 1], i)) {
				v[i] = true;
				arr[depth] = i;
				if (bt(depth + 1, dir, arr, sign, v)) return true;
				v[i] = false;
			}
		}
		
		return false;
	}
	
	static boolean compare(int x, char c, int y) {
		if (c == '>') return x > y;
		else return x < y;
	}
}

