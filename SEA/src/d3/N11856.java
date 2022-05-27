package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N11856 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			
			int[] arr = new int[26];
			int first = 0;
			int second = 0;
			boolean flag = true;
			
			for (int i = 0; i < 4; i++) {
				int idx = s.charAt(i) - 65;
				
				if (flag) {
					first = idx;
					flag = false;
				}
				
				if (first != idx) {
					second = idx;
				}
				
				arr[idx]++;
			}
			
			sb.append('#').append(t).append(' ');
			
			if (arr[first] == 2 && arr[second] == 2) sb.append("Yes").append('\n');
			else sb.append("No").append('\n');
		}
		
		System.out.println(sb);
	}

}
