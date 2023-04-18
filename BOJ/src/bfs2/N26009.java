package bfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N26009 {

    static class Node {
        int x;
        int y; 

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            check(r, c, d);
        }

        int answer = bfs();
        if (answer == -1) {
            sb.append("NO");
        } else {
            sb.append("YES\n").append(answer);
        }

        System.out.println(sb);
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        map[0][0] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return map[cur.x][cur.y] - 1;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (outOfMap(nx, ny)) continue;

                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return -1;
    }

    static void check(int r, int c, int d) {
        int n = 0;
        map[r][c] = -1;
        for (int i = 0; i <= d * 2; i++) {
            int nd = i >= d ? n-- : n++;
            int ur = r + nd;
            int dr = r - nd;
            int nc = c - d + i;

            if (!outOfMap(ur, nc)) {
                map[ur][nc] = -1;
            }

            if (!outOfMap(dr, nc)) {
                map[dr][nc] = -1;
            }
        }
    }

    static boolean outOfMap(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}
