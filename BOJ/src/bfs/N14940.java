package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N14940 {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] map;
    static boolean[][] v;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        v = new boolean[n][m];

        Node start = new Node(-1, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new Node(i, j);
                }
            }
        }

        bfs(start);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && map[i][j] == 1) {
                    answer.append(-1).append(' ');
                    continue;
                }

                answer.append(map[i][j]).append(' ');
            }

            answer.append('\n');
        }

        System.out.println(answer);
    }

    static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        v[start.x][start.y] = true;
        map[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (outOfMap(nx, ny)) {
                    continue;
                }

                if (!v[nx][ny] && map[nx][ny] == 1) {
                    v[nx][ny] = true;
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    static boolean outOfMap(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}
