package greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2109 {
	
	static class Lecture {
		int pay;
		int day;
		
		Lecture(int pay, int day) {
			this.pay = pay;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Lecture[] lectures = new Lecture[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			lectures[i] = new Lecture(p, d);
		}
		
		Arrays.sort(lectures, (l1, l2) -> (l1.pay == l2.pay) ? l2.day - l1.day : l2.pay - l1.pay);
		
		int ans = 0;
		boolean[] check = new boolean[10001];
		for (int i = 0; i < N; i++) {
			
			for (int j = lectures[i].day; j >= 1; j--) {
				if (!check[j]) {
					check[j] = true;
					ans += lectures[i].pay;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
