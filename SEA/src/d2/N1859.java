package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			int cnt = 0;
			int max = arr[arr.length - 1];
			
			for (int j = arr.length - 1; j > 0; j--) {
				
				if (max > arr[j - 1]) {
					sum -= arr[j - 1];
					cnt++;
				}
				
				else {
					sum += max * cnt;
					max = arr[j - 1];
					cnt = 0;
				}
			}
			
			sum += max * cnt;
			
			sb.append('#').append(i).append(' ').append(sum).append('\n');
		}
		
		System.out.println(sb);
	}
}
