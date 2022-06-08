package implementation2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N17144 {
	
	static int R, C, T;
	static int cleaner = -1;
	
	static int[][] map;
	static int[][] temp;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static Queue<Dust> q;
	
	static class Dust {
		int x;
		int y;
		int amount;
		
		Dust (int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (cleaner == -1 && map[i][j] == -1) {
					cleaner = i;
				}
			}
		}
		
		System.out.println(solution());
	}
	
	static int solution() {
		while (T-- > 0) {
			checkDust();
			
			spread();
			
			operateAirCleaner();
		}
		
		return getAmountOfDust();
	}
	
	static void checkDust() {
		q = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] >= 5) q.offer(new Dust(i, j, map[i][j]));
			}
		}
	}
	
	static void spread() {
		
		while (!q.isEmpty()) {
			Dust cur = q.poll();
			
			int amountOfSpread = cur.amount / 5;
			int cnt = 0;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (isInArea(nx, ny) && map[nx][ny] != -1) {
					map[nx][ny] += amountOfSpread;
					cnt++;
				}
			}
			
			map[cur.x][cur.y] -= amountOfSpread * cnt;
		}
	}
	
	static void operateAirCleaner() {
		int top = cleaner;
		int bottom = cleaner + 1;
		
		// 위쪽 공기청정기
		// 아래
		for (int i = top - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		// 왼쪽
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		// 위
		for (int i = 0; i < top; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		// 오른쪽
		for (int i = C - 1; i > 1; i--) {
			map[top][i] = map[top][i - 1];
		}
		map[top][1] = 0;
		
		// 아래쪽 공기청정기
		// 위
		for (int i = bottom + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		// 왼쪽
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		// 아래
		for (int i = R - 1; i > bottom; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		// 오른
		for (int i = C - 1; i > 1; i--) {
			map[bottom][i] = map[bottom][i - 1];
		}
		map[bottom][1] = 0;
	}
	
	static int getAmountOfDust() {
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1) continue;
				ans += map[i][j];
			}
		}
		
		return ans;
	}
	
	static boolean isInArea(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}
	
}
