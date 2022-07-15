package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2146_R {
	
	static int ans = Integer.MAX_VALUE;
	static int N;
	
	static int[][] map;
	static int[][] len;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		len = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution();
		
		System.out.println(ans);
	}
	
	static void solution() {
		Queue<int[]> q = new LinkedList<>();
		
		int landNum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, landNum++, q);
				}
			}
		}
		
		int depth = 1; // 다리 길이
		boolean flag = false;
		while (!q.isEmpty()) {
			int size = q.size();
			depth++;
			if (flag) break;
			
			while (size-- > 0) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (outOfArea(nx, ny)) continue;
					
					if (map[nx][ny] == 0) { // 바다면 다리를 놓음
						map[nx][ny] = map[x][y];
						len[nx][ny] = depth; // 다리 길이 입력
						q.offer(new int[] {nx, ny});
					}
					
					else if (map[nx][ny] != map[x][y]) { // 다른 섬의 코드면 연결되는 것
						if (ans > len[nx][ny] + len[x][y]) {
							ans = len[nx][ny] + len[x][y];
							flag = true;
						}
					}
				}
			}
		}
	}
	
	static void bfs(int x, int y, int landNum, Queue<int[]> q) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {x, y});
		map[x][y] = landNum;
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if (outOfArea(nx, ny)) continue;
				
				if (map[nx][ny] == 0) { // 바다면 길이 1의 다리를 놓음
					q.offer(new int[] {nx, ny});
					map[nx][ny] = landNum;
					len[nx][ny] = 1;
				}
				
				else if (map[nx][ny] == 1) { // 아직 확인안된 땅기면 계속 진행
					que.offer(new int[] {nx, ny});
					map[nx][ny] = landNum;
				}
			}
		}
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= N || y >= N;
	}

}
