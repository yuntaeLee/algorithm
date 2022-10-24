package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N2529 {
	
	static int k;
	static List<String> ans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		char[] sign = new char[k];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		bt(0, new int[k + 1], sign, new boolean[10]);
		
		Collections.sort(ans);
		
		sb.append(ans.get(ans.size() - 1))
			.append('\n')
			.append(ans.get(0));
		
		System.out.println(sb);
	}
	
	static void bt(int depth, int[] arr, char[] sign, boolean[] v) {
		if (depth == k + 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= k; i++) {
				sb.append(arr[i]);
			}
			
			ans.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (v[i]) continue;
			
			if (depth == 0 || compare(arr[depth - 1], sign[depth - 1], i)) {
				v[i] = true;
				arr[depth] = i;
				bt(depth + 1, arr, sign, v);
				v[i] = false;
			}
		}
	}
	
	static boolean compare(int x, char c, int y) {
		if (c == '>') return x > y;
		else return x < y;
	}
}

