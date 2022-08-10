package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2847 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = N - 1; i > 0; i--) {
			if (scores[i - 1] >= scores[i]) {
				ans += scores[i - 1] - (scores[i] - 1);
				scores[i - 1] = scores[i] - 1;
			}
		}

		System.out.println(ans);
	}
}
