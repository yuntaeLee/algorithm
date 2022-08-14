package greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N13904 {
	
	static class Homework {
		int d;
		int w;
		
		Homework(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int maxDay = 0;
		List<Homework> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.add(new Homework(d, w));
			maxDay = Math.max(maxDay, d);
		}
		
		int ans = 0;
		for (int i = maxDay; i > 0; i--) {
			ans += getMaxScoreInDay(list, i);
		}
		
		System.out.println(ans);
	}
	
	static int getMaxScoreInDay(List<Homework> list, int now) {
		int ans = 0;
		int idx = 0;
		
		for (int i = 0; i < list.size(); i++) {
			Homework h = list.get(i);
			
			if (h.d >= now && ans < h.w) {
				idx = i;
				ans = h.w;
			}
		}
		
		if (ans == 0) return 0;
		
		list.remove(idx);
		return ans;
	}
}
