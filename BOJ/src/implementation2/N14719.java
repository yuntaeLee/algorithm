package implementation2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] map = new int[W];
		
		int ans = 0;
		int left = 0;
		int right = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		// 첫번째 기둥과 마지막 기둥 제외
		for (int i = 1; i < W - 1; i++) {
			left = right = 0;
			
			// 왼쪽에서 가장 높은 건물 높이
			for (int j = 0; j < i; j++) {
				left = Math.max(map[j], left);
			}
			
			// 오른쪽에서 가장 높은 건물 높이
			for (int j = i + 1; j < W; j++) {
				right = Math.max(map[j], right);
			}
			
			if (map[i] < left && map[i] < right) {
				ans += Math.min(left, right) - map[i];
			}
		}
		
		System.out.println(ans);
	}

}
