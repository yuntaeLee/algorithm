package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {

	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 }; // x 방향 - 상하
	static int[] dy = { 0, 1, 0, -1 }; // y 방향 - 좌우
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(maze[N - 1][M - 1]);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				// 다음 좌표
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				
				// 다음 좌표가 범위를 넘어가면 패스
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				
				// 이미 방문했던 좌표또는 갈 수 없는 좌표일 경우 패스
				if (visited[nextX][nextY] || maze[nextX][nextY] == 0) continue;
				
				// 다음 방문좌표 offer
				q.offer(new int[] {nextX, nextY});
				visited[nextX][nextY] = true;
				
				// 가중치 부여
				maze[nextX][nextY] = maze[now[0]][now[1]] + 1;	
			}
		}
	}
}
