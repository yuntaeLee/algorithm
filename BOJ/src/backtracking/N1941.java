package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N1941 {
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int ans;
	static char[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Node[] nodes = new Node[7];
		bt(0, 0, nodes, new boolean[25]);
		
		System.out.println(ans);
	}
	
	static void bt(int depth, int start, Node[] nodes, boolean[] v) {
		if (depth == 7) {
			int cnt = 0;
			
			for (int i = 0; i < 7; i++) {
				if (map[nodes[i].x][nodes[i].y] == 'S') cnt++;
			}
			
			if (cnt >= 4 && bfs(nodes)) ans++;
			return;
		}
		
		for (int i = start; i < 25; i++) {
			if (!v[i]) {
				v[i] = true;
				nodes[depth] = new Node(i / 5, i % 5);
				bt(depth + 1, i + 1, nodes, v);
				v[i] = false;
			}
		}
	}
	
	static boolean bfs(Node[] nodes) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[7];
		q.offer(nodes[0]);
		visited[0] = true;
		
		int cnt = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			cnt++;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (outOfArea(nx, ny)) continue;
				
				for (int nIdx = 1; nIdx < 7; nIdx++) {
					if (visited[nIdx]) continue;
					
					Node next = nodes[nIdx];
					if (nx == next.x && ny == next.y) {
						visited[nIdx] = true;
						q.offer(new Node(nx, ny));
					}
				}
			}
		}
		
		return cnt == 7 ? true : false;
	}
	
	static boolean outOfArea(int x, int y) {
		return x < 0 || y < 0 || x >= 5 || y >= 5;
	}
}
