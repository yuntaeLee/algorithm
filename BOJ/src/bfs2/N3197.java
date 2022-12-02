package bfs2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N3197 {
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int R, C;
	static char[][] map;
	static boolean[][] v;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static List<Node> swans = new ArrayList<>();
	static Queue<Node> waterQ = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'L') {
					swans.add(new Node(i, j));
				}
				
				if (map[i][j] != 'X') {
					waterQ.offer(new Node(i, j));
				}
			}
		}
		
		System.out.println(solution());
	}
	
	static int solution() {
		Queue<Node> q = new LinkedList<>();
		Queue<Node> nextQ = new LinkedList<>();
		q.offer(new Node(swans.get(0).x, swans.get(0).y));
		
		int day = 0;
		while (true) {
			if (isMeet(q, nextQ)) {
				return day;
			}
			
			q = nextQ;
			nextQ = new LinkedList<>();
			
			melt();
			day++;
		}
	}
	
	static boolean isMeet(Queue<Node> q, Queue<Node> nextQ) {
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (outOfMap(nx, ny) || v[nx][ny]) continue;
				
				if (nx == swans.get(1).x && ny == swans.get(1).y) {
					return true;
				}
				
				v[nx][ny] = true;
				
				if (map[nx][ny] == 'X') {
					nextQ.offer(new Node(nx, ny));
					continue;
				}
				
				q.offer(new Node(nx, ny));
			}
		}
		
		return false;
	}
	
	static void melt() {
		int size = waterQ.size();
		
		for (int i = 0; i < size; i++) {
			Node cur = waterQ.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (outOfMap(nx, ny)) continue;
				
				if (map[nx][ny] == 'X') {
					map[nx][ny] = '.';
					waterQ.offer(new Node(nx, ny));
				}
			}
		}
	}
	
	static boolean outOfMap(int x, int y) {
		return x < 0 || y < 0 || x >= R || y >= C;
	}
	
}
