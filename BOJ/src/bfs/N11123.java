package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11123 {

    static int H;
    static int W;
    static char[][] map;
    static boolean[][] v;

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
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            v = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            int answer = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!v[i][j] && map[i][j] == '#') {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        v[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (outOfMap(nx, ny)) continue;

                if (v[nx][ny]) continue;

                if (map[nx][ny] == '#') {
                    q.offer(new Node(nx, ny));
                    v[nx][ny] = true;
                }
            }
        }
    }

    private static boolean outOfMap(int x, int y) {
        return x < 0 || y < 0 || x >= H || y >= W;
    }
}
