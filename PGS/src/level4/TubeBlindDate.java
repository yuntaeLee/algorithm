package level4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TubeBlindDate {

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int s = 25;
        int[][] time_map = {
            {0, 1, 1, -1, 2, 4}, 
            {-1, 7, 2, 1, 5, 7}, 
            {-1, 1, -1, 1, 6, 3}, 
            {-1, 1, -1, -1, 7, 0}
        };

        int[] actual = solution(m, n, s, time_map);

        int[] expect = {8, 15};
        System.out.println(Arrays.equals(actual, expect));
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int len;
        int cost;
        
        Node(int x, int y, int len, int cost) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            if (len == o.len) {
                return cost - o.cost;
            }
            
            return len - o.len;
        }
    }
    
    static final long INF = Integer.MAX_VALUE + 1L;
    
    static int M;
    static int N;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] solution(int m, int n, int s, int[][] time_map) {
        M = m;
        N = n;
      
        return dijkstra(time_map, s);
    }
    
    static int[] dijkstra(int[][] map, int s) {
        Queue<Node> q = new PriorityQueue<>();
        long[][] dist = new long[M][N];
        for (long[] arr : dist) {
            Arrays.fill(arr, INF);
        }
        
        q.offer(new Node(0, 0, 0, 0));
        dist[0][0] = 0;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.x == M - 1 && cur.y == N - 1) {
                return new int[] {cur.len, (int) dist[cur.x][cur.y]};
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nl = cur.len + 1;
                
                if (outOfMap(nx, ny) || map[nx][ny] == -1) continue;
                
                long nextCost = dist[cur.x][cur.y] + map[nx][ny];
                if (nextCost > s) continue;
                
                if (dist[nx][ny] > nextCost) {
                    dist[nx][ny] = nextCost;
                    q.offer(new Node(nx, ny, nl, (int) dist[nx][ny]));
                }
            }
        }
        
        return new int[] {-1, -1};
    }
    
    static boolean outOfMap(int x, int y) {
        return x < 0 || y < 0 || x >= M || y >= N;
    }
}
