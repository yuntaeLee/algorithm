package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2583_B {
	
	static int M;
	static int N;
	
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		List<Integer> list = new ArrayList<>();
		
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			for (int x = startX; x < endX; x++) {
				for (int y = startY; y < endY; y++) {
					map[y][x] = 1;
				}
			}
		}
		
		
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] == 0) {
					list.add(bfs(x, y));
				}
			}
		}
		
		Collections.sort(list);
		
		sb.append(list.size()).append('\n');
		for (int i : list) sb.append(i).append(' ');
		
		System.out.println(sb);
	}
	
	
	static int bfs(int x, int y) {
		int result = 1;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		map[x][y] = 1;
		
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int xx = xy[0] + dx[i];
				int yy = xy[1] + dy[i];
				
				if (xx >= 0 && yy >= 0 && xx < M && yy < N) {
					if (map[xx][yy] == 0) {
						map[xx][yy] = 1;
						q.offer(new int[] {xx, yy});
						result++;
					}
				}
			}
		}
		
		return result;
	}
}
