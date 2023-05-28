package level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import sogang_contest.B;
import sogang_contest.E;

public class RacewayConstruction {

    static class Node {
        int x;
        int y;
        int dir;
        
        Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 0, 0, 0}, 
            {0, 1, 1, 1, 0}, 
            {0, 0, 1, 0, 0}, 
            {1, 0, 0, 0, 1}, 
            {0, 1, 1, 0, 0}
        };

        int actual = solution(board);

        int expected = 3000;
        System.out.println(actual == expected);
    }

    static int solution(int[][] board) {
        n = board.length;
        return bfs(board);
    }
    
    static int bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        int[][][] dist = new int[n][n][4];
        for (int[][] dis : dist) {
            for (int[] arr : dis) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = dist[0][0][1] = dist[0][0][2] = dist[0][0][3] = 0;
        
        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.x == n - 1 && cur.y == n - 1) {
                answer = Math.min(answer, dist[cur.x][cur.y][cur.dir]);
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (outOfBoard(nx, ny) || board[nx][ny] == 1) {
                    continue;
                }
                
                int nextCost = dist[cur.x][cur.y][cur.dir] + 100;
                if (!(cur.x == 0 && cur.y == 0) && cur.dir != d) {
                    nextCost += 500;
                }
                
                if (dist[nx][ny][d] >= nextCost) {
                    dist[nx][ny][d] = nextCost;
                    q.offer(new Node(nx, ny, d));
                }
            }
        }
        
        return answer;
    }
    
    static boolean outOfBoard(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
