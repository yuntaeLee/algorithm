package zcontest_799_div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			Set<Integer> set = new HashSet<>();
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {	
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			if ((n - set.size()) % 2 == 0) sb.append(set.size());
			else sb.append(set.size() - 1);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
