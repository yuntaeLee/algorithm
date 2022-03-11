package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1080 {
	
	static int ans = 0;
	static int N, M;
	
	static int[][] input;
	static int[][] output;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N][M];
		output = new int[N][M];
		
		input = makeArray(input);
		output = makeArray(output);

		for (int x = 0; x < N - 2; x++) {
			for (int y = 0; y < M - 2; y++) {
				if (input[x][y] != output[x][y]) {
					flipArray(x, y);
					ans++;
				}
			}
		}
		
		if (!isSame(input, output)) ans = -1;
		System.out.println(ans);
	}
	
	
	static boolean isSame(int[][] input, int[][] output) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (input[i][j] != output[i][j]) return false;
			}
		}
		
		return true;
	}
	
	
	static int[][] makeArray(int[][] arr) throws IOException {
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		return arr;
	}
	
	
	static int[][] flipArray(int x, int y) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				input[i][j] = (input[i][j] == 1) ? 0 : 1;
			}
		}
		
		return input;
	}
	
}
