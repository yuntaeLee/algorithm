package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] ground = new int[N][M];
		int min = 256;
		int max = 0;
		
		int answerTime = Integer.MAX_VALUE;
		int answerHeight = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				
				min = Math.min(min, ground[i][j]);
				max = Math.max(max, ground[i][j]);
			}
		}
		
		for (int height = min; height <= max; height++) {
			
			int time = 0;
			int block = B;
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					
					if (ground[n][m] == height) continue;
					
					else {
						int diff = Math.abs(height - ground[n][m]);
						if (height > ground[n][m]) {
							block -= diff;
							time += diff;
						}
						
						else {
							block += diff;
							time += 2 * diff;
						}
					}
				}
			}
			
			if (block >= 0) {
				// �ð��� ������ ���� ���̰� ���� ���� �켱�̱� ������ �ε�ȣ <= ���
				if (time <= answerTime) {
					answerTime = time;
					answerHeight = height;
				}
			}
		}
		
		sb.append(answerTime).append(' ').append(answerHeight);
		System.out.println(sb);
	}
}
