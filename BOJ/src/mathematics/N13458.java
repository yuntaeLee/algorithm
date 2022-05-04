package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] clazz = new int[N];
		long ans = N;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			clazz[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			long n = clazz[i] - B;
			
			if (n > 0) {
				if (n % C == 0) {
					ans += n / C;
				} else {
					ans += n / C + 1;
				}
			}
		}
		
		System.out.println(ans);
	}
}
