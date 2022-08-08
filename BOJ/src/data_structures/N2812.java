package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class N2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		
		Stack<Integer> stk = new Stack<>();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			int n = s.charAt(i) - '0';
			
			if (!stk.isEmpty()) {
				while (!stk.isEmpty() && cnt < K) {
					if (stk.peek() < n) {
						stk.pop();
						cnt++;
					} else break;
				}
			}
			
			stk.push(n);
			
			if (cnt == K) {
				sb.append(s.substring(i + 1));
				break;
			}
		}
		System.out.println(sb);

		while (!stk.isEmpty() ) {
			int n = stk.pop();
			
			if (cnt < K) {
				cnt++;
				continue;
			}
			sb.insert(0, n);
		}
		
		System.out.println(sb);
	}
}
