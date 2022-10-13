package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1182 {
	
	static int ans;
	static int N, S;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bt(0, 0);
		
		System.out.println(S == 0 ? ans - 1 : ans);
	}
	
	static void bt(int depth, int value) {
		if (depth == N) {
			if (value == S) {
				ans++;
			}
			return;
		}
		
		bt(depth + 1, value + arr[depth]); // 선택
		bt(depth + 1, value); // 선택x
	}
}
