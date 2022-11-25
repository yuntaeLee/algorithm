package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N6593 {
	
	static class Node {
		int l;
		int r;
		int c;
		
		Node(int l, int r, int c) {
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}
	
	static int L, R, C;
	static char[][][] map;
	
	static int[] dr = {-1, 0, 1, 0, 0, 0};
	static int[] dc = {0, -1, 0, 1, 0, 0};
	static int[] dl = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			
			map = new char[L][R][C];
			
			Node start = null;
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String s = br.readLine();
					
					if (s.equals("")) {
						s = br.readLine();
					}
					
					for (int c = 0; c < C; c++) {
						map[l][r][c] = s.charAt(c);
						
						if (map[l][r][c] == 'S') {
							start = new Node(l, r, c);
						}
					}
				}
			}
			
			int ans = bfs(start);
			if (ans == -1) {
				sb.append("Trapped!");
			} else {
				sb.append(String.format("Escaped in %d minute(s).", ans));
			}
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		int[][][] dist = new int[L][R][C];
		q.offer(start);
		dist[start.l][start.r][start.c] = 1;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int d = 0; d < 6; d++) {
				int nl = cur.l + dl[d];
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if (outOfBuilding(nl, nr, nc)) continue;
				
				if (dist[nl][nr][nc] == 0 && map[nl][nr][nc] != '#') {
					dist[nl][nr][nc] = dist[cur.l][cur.r][cur.c] + 1;
					q.offer(new Node(nl, nr, nc));
				}
				
				if (map[nl][nr][nc] == 'E') {
					return dist[nl][nr][nc] - 1;
				}
			}
		}
		
		return -1;
	}
	
	static boolean outOfBuilding(int l, int r, int c) {
		return l < 0 || r < 0 || c < 0 || l >= L || r >= R || c >= C;
	}
	
}
