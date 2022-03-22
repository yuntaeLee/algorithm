package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N4963_B {
	
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, 1, 1, -1, -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String s;
		while (!(s = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(s, " ");
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(solution()).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int solution() {
		int answer = 0;
		
		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				if (!visited[x][y] && map[x][y] == 1) {
					dfs(x, y);
					answer++;
				}
			}
		}
		
		return answer;
	}
	
	static void dfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] xy = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int xx = xy[0] + dx[i];
				int yy = xy[1] + dy[i];
				
				if (xx >= 0 && yy >= 0 && xx < h && yy < w) {
					if (!visited[xx][yy] && map[xx][yy] == 1) {
						visited[xx][yy] = true;
						q.offer(new int[] {xx, yy});
					}
				}
			}
		}
	}
}
