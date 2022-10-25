package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N16922 {
	
	static int n, ans;
	static int[] arr = {1, 5, 10, 50};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		bt(0, 0, new boolean[1001], 0);
		
		System.out.println(ans);
	}
	
	static void bt(int depth, int start, boolean[] v, int sum) {
		if (depth == n) {
			if (!v[sum]) {
				v[sum] = true;
				ans++;
			}
			
			return;
		}
		
		for (int i = start; i < 4; i++) {
			bt(depth + 1, i, v, sum + arr[i]);
		}
	}
}
