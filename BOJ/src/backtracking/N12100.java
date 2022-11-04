package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12100 {
	
	static int ans;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0}; 
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bt(0, 5, new int[5]);
		
		System.out.println(ans);
	}
	
	static void bt(int depth, int count, int[] directions) {
		if (depth == count) {
			ans = Math.max(ans, getPuzzleMaxNumber(directions));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			directions[depth] = i;
			bt(depth + 1, count, directions);
		}
	}
	
	static int getPuzzleMaxNumber(int[] directions) {
		int[][] puzzle = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			puzzle[i] = map[i].clone();
		}
		
		for (int d = 0; d < directions.length; d++) {
			visited = new boolean[N][N];
			selectPoint(puzzle, directions[d]);
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, puzzle[i][j]);
			}
		}
		
		return max;
	}
	
	static void selectPoint(int[][] puzzle, int dir) {
		if (dir == 0) { // 상
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					move(i, j, puzzle, dir);
				}
			}
		} else if (dir == 1) { // 하
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					move(i, j, puzzle, dir);
				}
			}
		} else if (dir == 2) { // 좌
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					move(j, i, puzzle, dir);
				}
			}
		} else { // 우
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					move(j, i, puzzle, dir);
				}
			}
		}
	}
	
	static void move(int x, int y, int[][] puzzle, int dir) {
		if (puzzle[x][y] == 0) return;
		
		while (true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if (outOfPuzzle(nx, ny)) return;
			if (visited[nx][ny]) return;
			
			if (puzzle[nx][ny] == puzzle[x][y]) {
				puzzle[nx][ny] *= 2;
				puzzle[x][y] = 0;
				visited[nx][ny] = true;
				return;
			} else if (puzzle[nx][ny] != 0) return;
			
			puzzle[nx][ny] = puzzle[x][y];
			puzzle[x][y] = 0;
			x = nx;
			y = ny;
		}
	}
	
	static boolean outOfPuzzle(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >=N;
	}
}
