package divde_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1780 {
	
	static int N;
	static int[][] papers;
	
	static int zeros;
	static int ones;
	static int minus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		papers = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				papers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0, 0, N);
		
		sb.append(minus).append('\n').append(zeros).append('\n').append(ones);
		System.out.println(sb);
	}
	
	static void solution(int x, int y, int size) {
		
		if (isSamePaper(x, y, size)) {
			int paper = papers[x][y];
			
			if (paper == -1) minus++;
			else if (paper == 0) zeros++;
			else ones++;
			return;
		}
		
		else {
			int newSize = size / 3;
			
			solution(x, y, newSize);							 // 왼쪽 위
			solution(x, y + newSize, newSize);					 // 중앙 위
			solution(x, y + 2 * newSize, newSize);				 // 오른쪽 위
			
			solution(x + newSize, y, newSize);					 // 왼쪽 중앙
			solution(x + newSize, y + newSize, newSize);		 // 중앙 중앙
			solution(x + newSize, y + 2 * newSize, newSize);	 // 오른족 중앙
			
			solution(x + 2 * newSize, y, newSize);				 // 왼쪽 아래
			solution(x + 2 * newSize, y + newSize, newSize);	 // 중앙 아래
			solution(x + 2 * newSize, y + 2 * newSize, newSize); // 오른쪽 아래
		}
		
	}
	
	static boolean isSamePaper(int x, int y, int size) {
		int paper = papers[x][y]; 
		for (int i = x; i < x + size; i++) {
			 for (int j = y; j < y + size; j++) {
				 if (paper != papers[i][j]) return false;
			 }
		}
		
		return true;
	}

}
