package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0;
		int right = -1;
		
		st = new StringTokenizer(br.readLine());
		
		while (++right < N) {
			sum += nums[right] = Integer.parseInt(st.nextToken());
			
			while (sum >= S) {
				ans = Math.min(ans, right - left + 1);
				sum -= nums[left++];
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}