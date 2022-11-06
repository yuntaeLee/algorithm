package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1525 {
	
	static String solved = "123456780";
	static Map<String, Integer> map = new HashMap<>();
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder init = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				init.append(st.nextToken());
			}
		}
		
		map.put(init.toString(), 0);
		
		System.out.println(bfs(init.toString()));
	}
	
	static int bfs(String init) {
		Queue<String> q = new LinkedList<>();
		q.offer(init);
		
		while (!q.isEmpty()) {
			String curPuzzle = q.poll();
			int move = map.get(curPuzzle);
			int cur = curPuzzle.indexOf('0');
			int x = cur / 3;
			int y = cur % 3;
			if (curPuzzle.equals(solved)) {
				return move;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (outOfPuzzle(nx, ny)) continue;
				
				int next = nx * 3 + ny;
				String nextPuzzle = swap(curPuzzle, cur, next);
				
				if (!map.containsKey(nextPuzzle)) {
					map.put(nextPuzzle, move + 1);
					q.offer(nextPuzzle);
				}
			}
		}
		
		return -1;
	}
	
	static String swap(String puzzle, int cur, int next) {
		StringBuilder sb = new StringBuilder(puzzle);
		char c = sb.charAt(cur);
		char n = sb.charAt(next);
		sb.setCharAt(cur, n);
		sb.setCharAt(next, c);
		
		return sb.toString();
	}
	
	static boolean outOfPuzzle(int x, int y) {
		return x < 0 || y < 0 || x >= 3 || y >= 3;
	}
}
