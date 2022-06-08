package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1759 {
	
	static int L;
	static int C;
	
	static char[] arr;
	static char[] code;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		code = new char[L];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		makeCode(0, 0);
		System.out.println(sb);
	}
	
	static void makeCode(int x, int index) {
		
		if (index == L) {
			if (isValid()) {
				sb.append(code).append('\n');
			}
			
			return;
		}
		
		for (int i = x; i < C; i++) {
			code[index] = arr[i];
			makeCode(i + 1, index + 1);
		}
	}
	
	// 최소 모음 1개, 최소 자음 2개 확인
	static boolean isValid() {
		int m = 0; // 모음
		int j = 0; // 자음
		
		for (char x : code) {
			if (x == 'a' || x == 'e' || x == 'i' || x =='o' || x == 'u') m++;
			else j++;
		}
		
		if (m >= 1 && j >= 2) return true;
		return false;
	}
}
