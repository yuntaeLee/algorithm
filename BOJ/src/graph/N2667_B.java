package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class N2667_B {
	
	static int N;
	static int count;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	static ArrayList<Integer> result; // 단지 집의 수 저장, size는 단지 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		result = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] == 1 && !visited[x][y]) {
					count = 0;
					bfs(x, y);
					result.add(count);
				}
			}
		}
		
		Collections.sort(result);
		sb.append(result.size()).append('\n');
		for (int c : result) sb.append(c).append('\n');
		
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			count++;
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				if (visited[nx][ny]) continue;
				
				if (map[nx][ny] == 1) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		
	}

}
