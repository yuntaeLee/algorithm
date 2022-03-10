package round124div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProveHimWrong {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if (n > 19) sb.append("NO").append('\n');
			else {
				sb.append("YES").append('\n');
				
				int[] arr = new int[n];
				arr[0] = 1;
				for (int i = 1; i < n; i++) {
					arr[i] = arr[i - 1] * 3;
				}
				
				for (int i = 0; i < n; i++) {
					sb.append(arr[i]).append(' ');
				}
				
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
