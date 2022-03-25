package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N2583_D {
	
	static int count;
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
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] == 0) {
					count = 0;
					dfs(x, y);
					list.add(count);
				}
			}
		}
		
		Collections.sort(list);
		
		sb.append(list.size()).append('\n');
		for (int i : list) sb.append(i).append(' ');
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		map[x][y] = 1;
		count++;
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx >= 0 && yy >=0 && xx < M && yy < N) {
				if (map[xx][yy] == 0) {
					dfs(xx, yy);
				}
			}
		}
	}

}
