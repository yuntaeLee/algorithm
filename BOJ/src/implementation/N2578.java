package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2578 {
	
	static int ans;
	static int bingoCount;
	static int[] point = new int[2];
	static int[][] bingo = new int[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(st.nextToken());
				getPoint(n);
				
				if (ans >= 5) {
					int x = point[0];
					int y = point[1];
					
					checkRow(x);
					checkCol(y);
					
					if (x == y) checkLeft();
					if (x + y == 4) checkRight();
				}
				
				if (bingoCount >= 3) {
					System.out.println(ans);
					return;
				}
			}
		}
		
	}
	
	static void getPoint(int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				if (bingo[i][j] == n) {	
					bingo[i][j] = 0;
					point = new int[] {i, j};
					ans++;
					
					return;
				}
			}
		}
	}
	
	static void checkRow(int x) {
		for (int i = 0; i < 5; i++) {
			if (bingo[x][i] != 0) return;	
		}
		
		bingoCount++;
	}
	
	static void checkCol(int y) {
		for (int i = 0; i < 5; i++) {
			if (bingo[i][y] != 0) return;
		}
		
		bingoCount++;
	}
	
	static void checkLeft() {
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] != 0) return;
		}
		
		bingoCount++;
	}
	
	static void checkRight() {
		for (int i = 0; i < 5; i++) {
			if (bingo[i][4 - i] != 0) return;
		}
		
		bingoCount++;
	}
}
