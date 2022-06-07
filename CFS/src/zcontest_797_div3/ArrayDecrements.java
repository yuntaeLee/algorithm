package zcontest_797_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDecrements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
	
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 1) {
				int a = Integer.parseInt(br.readLine());
				int b = Integer.parseInt(br.readLine());
				
				if (a >= b) sb.append("YES").append('\n');
				else sb.append("NO").append('\n');
			}
			
			else {
				StringTokenizer stA = new StringTokenizer(br.readLine());
				StringTokenizer stB = new StringTokenizer(br.readLine());
				
				int[] a = new int[n];
				int[] b = new int[n];
				int maxdiff = 0;
				boolean flag = true;
				
				for (int i = 0; i < n; i++) {
					a[i] = Integer.parseInt(stA.nextToken());
					b[i] = Integer.parseInt(stB.nextToken());
					
					if (a[i] < b[i]) {
						sb.append("NO").append('\n');
						flag = false;
						break;
					}
					
					maxdiff = Math.max(maxdiff, Math.abs(a[i] - b[i]));
				}
				
				if (!flag) continue;
				
				for (int i = 0; i < n; i++) {
					int k = Math.max(a[i] - maxdiff, 0);
					if (k == b[i]) continue;
					
					sb.append("NO").append('\n');
					flag = false;
					break;
				}
				
				if (!flag) continue;
				
				sb.append("YES").append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
