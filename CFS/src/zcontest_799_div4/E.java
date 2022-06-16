package zcontest_799_div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class E {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int sum = Integer.parseInt(st.nextToken());
			
			List<Integer> ones = new ArrayList<>();
			ones.add(-1);
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				if (Integer.parseInt(st.nextToken()) == 1) ones.add(i); 
			}
			ones.add(n);
			
			if (ones.size() < sum + 2) {
				sb.append("-1").append('\n');
				continue;
			}
			
			int ans = 0;
			for (int i = sum + 1; i < ones.size(); i++) {
				ans = Math.max(ones.get(i) - ones.get(i - sum - 1), ans);
			}
			
			sb.append(n - ans + 1).append('\n');
		}
		
		System.out.println(sb);
	}

}
