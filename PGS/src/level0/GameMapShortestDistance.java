package level0;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {

	public static void main(String[] args) {
		
	}
	
    static int n, m;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        
        q.offer(new Node(0, 0));
        dist[0][0] = 1;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (outOfMap(nx, ny)) continue;
                
                if (maps[nx][ny] == 1 && dist[nx][ny] == 0) {
                    q.offer(new Node(nx, ny));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
                
                if (nx == n - 1 && ny == m - 1) {
                    return dist[nx][ny];
                }
            }
        }
        
        return -1;
    }
    
    static boolean outOfMap(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

}
