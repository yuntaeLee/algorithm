package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3190 {
	
	static int N;
	
	static int[][] map;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static Map<Integer, String> moveInfo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		moveInfo = new HashMap<>();

		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		while (L-- > 0) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			moveInfo.put(t, d);
		}
		
		solution();
	}

	static void solution() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		int time = 0;
		int d = 0;
		int px = 0;
		int py = 0;
		
		while (true) {
			int nx = px + dx[d];
			int ny = py + dy[d];
			time++;
			
			// 벽 부딪힘
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
			
			// 몸통 부딪힘
			if (q.contains(ny * N + nx)) break;
			
			if (map[ny][nx] == 1) {
				map[ny][nx] = 0;
				q.offer(ny * N + nx);
			} else {
				q.offer(ny * N + nx);
				q.poll();
			}
			
			// 방향 전환
			if (moveInfo.containsKey(time)) {
				String direction = moveInfo.get(time);
				
				if (direction.contains("D")) {
					if (++d == 4) d = 0;
				} else {
					if (--d == -1) d = 3;
				}
			}
			
			px = nx;
			py = ny;
		}
		
		System.out.println(time);
	}
}
