package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N18111_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		int height = 0;
		int[] cnt = new int[257];
		
		int minHeight = 257;
		int maxHeight = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				cnt[num]++;
				
				minHeight = Math.min(minHeight, num);
				maxHeight = Math.max(maxHeight, num);
			}
		}
		
		for (int i = minHeight; i <= maxHeight; i++) {
			
			int time = 0;
			int block = B;
			
			for (int j = 0; j <= 256; j++) {
				
				if (cnt[j] == 0 || i == j) continue;
				
				int diff = Math.abs(j - i);
				
				if (j > i) {
					time += 2 * diff * cnt[j];
					block += diff * cnt[j];
				}
				
				else {
					time += diff * cnt[j];
					block -= diff * cnt[j];
				}
			}
			
			// 블록이 모자라면 넘어간다.
			if (block < 0) continue;
			
			if (time < min) {
				min = time;
				height = i;
			}
			
			else if (time == min && i > height) {
				height = i;
			}
		}
		
		sb.append(min).append(' ').append(height);
		System.out.println(sb);
	}
}
