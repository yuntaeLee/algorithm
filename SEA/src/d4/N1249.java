package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class N1249 {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }

    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            sb.append('#').append(t).append(' ').append(bfs()).append('\n');
        }

        System.out.println(sb);
    }

    static int bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[][] v = new boolean[N][N];
        q.offer(new Node(0, 0, map[0][0]));
        v[0][0] = true;

        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                return Math.min(answer, cur.time);
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (outOfMap(nx, ny)) continue;

                if (!v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.time + map[nx][ny]));
                }
            }
        }

        return -1;
    }

    static boolean outOfMap(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}
