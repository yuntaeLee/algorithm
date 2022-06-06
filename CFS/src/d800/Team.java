package d800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Team {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			ans = sum > 1 ? ans + 1 : ans;
		}
		
		System.out.println(ans);
	}
}
