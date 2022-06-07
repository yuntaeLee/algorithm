package zcontest_797_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RestoringTheDuraionOfTasks {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] s = new int[n];
			int[] f = new int[n];
			
			StringTokenizer ss = new StringTokenizer(br.readLine());
			StringTokenizer sf = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				s[i] = Integer.parseInt(ss.nextToken());
				f[i] = Integer.parseInt(sf.nextToken());
			}
			
			int[] ans = new int[n];
			ans[0] = f[0] - s[0];
			
			for (int i = 1; i < n; i++) {
				if (f[i - 1] > s[i]) {
					ans[i] = f[i] - f[i - 1];
				}
				else {
					ans[i] = f[i] - s[i];
				}
			}
			
			for (int val : ans) sb.append(val).append(' ');
			sb.append('\n');
			
		}
		
		System.out.println(sb);
	}

}
