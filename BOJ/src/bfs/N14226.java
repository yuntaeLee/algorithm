package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N14226 {
	
	static class Emoticon {
		int screen;
		int board;
		int time;
		
		Emoticon (int screen, int board, int time) {
			this.screen = screen;
			this.time = time;
			this.board = board;
		}
	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = Integer.parseInt(br.readLine());
		
		System.out.println(bfs(S));
	}
	
	static int bfs(int s) {
		Queue<Emoticon> q = new LinkedList<>();
		boolean[][] visited = new boolean[1001][1001]; // 행- 화면, 열- 클립보드
		q.offer(new Emoticon(1, 0, 0));
		visited[1][0] = true;
		
		while (!q.isEmpty()) {
			Emoticon cur = q.poll();
			
			if (cur.screen == s) return cur.time;
			
			// 복사
			q.offer(new Emoticon(cur.screen, cur.screen, cur.time + 1));
			
			// 붙혀 넣기
			if (isInArea(cur.screen + cur.board) &&
					!visited[cur.screen + cur.board][cur.board] &&
					cur.board != 0) {
				
				visited[cur.screen + cur.board][cur.board] = true;
				q.offer(new Emoticon(cur.screen + cur.board, cur.board, cur.time + 1));
			}
			
			// 삭제
			if (isInArea(cur.screen - 1) && !visited[cur.screen - 1][cur.board]) {
				visited[cur.screen - 1][cur.board] = true;
				q.offer(new Emoticon(cur.screen - 1, cur.board, cur. time + 1));
			}
		}
		
		return -1;
	}
	
	static boolean isInArea(int n) {
		return 1 < n && n < 1001;
	}
}
