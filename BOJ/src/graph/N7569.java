package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7569 {
	
	static int M, N, H;
	static int[][][] map;
	
	static int[] dx = { 1, 0, -1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					
					if (map[i][j][k] == 1) q.offer(new int[] {i, j, k});
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		while (!q.isEmpty()) {
			int[] xyz = q.poll();
			int z = xyz[0];
			int x = xyz[1];
			int y = xyz[2];
			
			for (int i = 0; i < 6; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				int zz = z + dz[i];
				
				if (xx >= 0 && yy >= 0 && zz >= 0 && xx < N && yy < M && zz < H) {
					if (map[zz][xx][yy] == 0) {
						q.offer(new int[] {zz, xx, yy});
						map[zz][xx][yy] = map[z][x][y] + 1;
					}
				}
			}
		}
		
		return solution();
	}
	
	private static int solution() {
		int answer = 0;
		
		for (int[][] arrr : map) {
			for (int[] arr : arrr) {
				for (int a : arr) {
					if (a == 0) return -1;
					
					answer = Math.max(answer, a);
				}
			}
		}
		
		if (answer == 1) return 0;
		else return answer - 1;
	}
}
