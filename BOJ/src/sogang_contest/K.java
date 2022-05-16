package sogang_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String[] arr = new String[4];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[j] = st.nextToken();
			}
			
			if (condition1(arr) || condition2(arr) || condition3(arr)) {
				sb.append(":)").append('\n');
			} else sb.append(":(").append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean condition1(String[] arr) {
		Arrays.sort(arr);
		
		for (int i = 0; i < 4; i++) {
			int n1 = arr[i].charAt(0) - '0';
			char c1 = arr[i].charAt(1);
			
			int cnt = 1;
			
			for (int j = 0; j < 4; j++) {
				if (i == j) continue;
				
				int n2 = arr[j].charAt(0) - '0';
				char c2 = arr[j].charAt(1);
				
				if (c1 == c2 && n1 + 1 == n2) {
					n1++;
					cnt++;
				}
			}
			
			if (cnt >= 3) return true;
		}
		
		return false;
	}
	
	static boolean condition2(String[] arr) {
		if (arr[0].equals(arr[1]) && arr[0].equals(arr[2])) return true;
		else if (arr[0].equals(arr[1]) && arr[0].equals(arr[3])) return true;
		else if (arr[1].equals(arr[2]) && arr[1].equals(arr[3])) return true;
		else return false;
	}
	
	static boolean condition3(String[] arr) {
		if (arr[0].equals(arr[1]) && arr[2].equals(arr[3])) return true;
		else if (arr[0].equals(arr[2]) && arr[1].equals(arr[3])) return true;
		else if (arr[0].equals(arr[3]) && arr[1].equals(arr[2])) return true;
		else return false;
	}

}
