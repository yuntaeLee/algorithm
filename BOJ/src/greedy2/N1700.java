package greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1700 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] schedule = new int[K];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			schedule[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] multitap = new boolean[K + 1];
		int put = 0;
		int ans = 0;
		
		for (int i = 0; i < K; i++) {
			int n = schedule[i];
			
			// 콘센트가 꽂혀있지 않은 경우
			if (!multitap[n]) { 
				
				// 콘센트를 꽂을 공간이 있는 경우
				if (put < N) {
					multitap[n] = true;
					put++;
				}
				
				// 콘센트를 꽂을 공간이 없는 경우
				else {
					List<Integer> list = new ArrayList<>();
					for (int j = i; j < K; j++) {
						if (!list.contains(schedule[j]) && multitap[schedule[j]]) {
							list.add(schedule[j]);
						}
					}
					
					// 나중에도 사용되는 콘센트가 구멍의 개수보다 작을 경우
					if (list.size() < N) {
						for (int j = 0; j < multitap.length; j++) {
							if (multitap[j] && !list.contains(j)) {
								multitap[j] = false;
								break;
							}
						}
					}
					
					// 현재 꽂혀 있는 모든 콘센트가 나중에도 사용될 경우
					else {
						int last = list.get(list.size() - 1);
						multitap[last] = false;
					}
					
					multitap[n] = true;
					ans++;
				}
			}
		}

		System.out.println(ans);
	}
}
