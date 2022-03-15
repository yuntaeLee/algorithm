package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7576 {
	
	static int count;
	static int N, M;
	static int[][] map;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) q.offer(new int[] {i, j});
			}
		}
		
		bfs();
		
		System.out.println(getResult());
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int xx = xy[0] + dx[i];
				int yy = xy[1] + dy[i];
				
				if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
					if (map[xx][yy] == 0) {
						q.offer(new int[] {xx, yy});
						map[xx][yy] = map[xy[0]][xy[1]] + 1;
						count = map[xx][yy];
					}
				}
			}
		}
		
	}
	
	static int getResult() {
		if (hasZero(map)) return -1;
		else if (count == 0) return 0;
		else return count - 1;
	}
	
	
	static boolean hasZero(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) return true;
			}
		}
		
		return false;
	}
}
