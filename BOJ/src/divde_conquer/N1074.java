package divde_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1074 {
	
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = (int) Math.pow(2, N); // 한 번의 크기
		
		solution(r, c, n);
		System.out.println(count);
	}
	
	static void solution(int r, int c, int n) {
		if (n == 1) return;
		
		int nn = n / 2;
		
		if (r < nn && c < nn) {
			solution(r, c, nn);
		}
		else if (r < nn && c >= nn) {
			count += n * n / 4;
			solution(r, c - nn, nn);
		}
		else if (r >= nn && c < nn) {
			count += (n * n / 4) * 2;
			solution(r - nn, c, nn);
		}
		else {
			count += (n * n / 4) * 3;
			solution(r - nn, c - nn, nn);
		}
	}
}
