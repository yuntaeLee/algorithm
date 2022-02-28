package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1932 {
	
	static int N;
	static int[][] arr;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new Integer[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가장 마지막 행을 dp에 복사
		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = arr[N - 1][i];
		}
		
		System.out.println(find(0, 0));
		
	}
	
	// depth: 행
	// idx: 열
	static int find(int depth, int idx) {
		
		// 만약 맨 밑(깊이)의 행에 도달하면 해당 인덱스를 반환
		if (depth == N - 1) return dp[depth][idx];
		
		// 만약 아직 탐색하지 않은 위치라면 다음 행의 양쪽 열 중 최댓갑을 구함
		if (dp[depth][idx] == null) {
			
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
		}
		
		return dp[depth][idx];
	}
}
