package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1149 {
	
	final static int RED = 0;
	final static int GREEN = 1;
	final static int BLUE = 2;
	
	static int[][] cost;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			cost[i][RED] = Integer.parseInt(st.nextToken());
			cost[i][GREEN] = Integer.parseInt(st.nextToken());
			cost[i][BLUE] = Integer.parseInt(st.nextToken());
		}
		
		// dp의 첫번째 값은 각 색상비용의 첫번째 값으로 초기화
		dp[0][RED] = cost[0][RED];
		dp[0][GREEN] = cost[0][GREEN];
		dp[0][BLUE] = cost[0][BLUE];
		
		
		System.out.println(Math.min(getPaintCost(N - 1, RED), Math.min(getPaintCost(N - 1, GREEN), getPaintCost(N - 1, BLUE))));
		
	}
	
	static int getPaintCost(int N, int color) {
		
		// 탐색하지 않은 배열이라면
		if (dp[N][color] == 0) {
			
			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 dp에 저장
			if (color == RED) {
				dp[N][RED] = Math.min(getPaintCost(N - 1, GREEN), getPaintCost(N - 1, BLUE)) + cost[N][RED];
			}
			
			else if (color == GREEN) {
				dp[N][GREEN] = Math.min(getPaintCost(N - 1, RED), getPaintCost(N - 1, BLUE)) + cost[N][GREEN];
			}
			
			else {
				dp[N][BLUE] = Math.min(getPaintCost(N - 1, RED), getPaintCost(N - 1, GREEN)) + cost[N][BLUE];
			}
		}
		
		return dp[N][color];
	}

}
