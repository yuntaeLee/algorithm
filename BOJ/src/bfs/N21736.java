package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N21736 {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static char[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        Node start = new Node(-1, -1);

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'I') {
                    start = new Node(i, j);
                }
            }
        }

        int answer = bfs(start);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    static int bfs(Node start) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] v = new boolean[N][M];
        q.offer(start);
        v[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (outOfMap(nx, ny) || map[nx][ny] == 'X') {
                    continue;
                }

                if (!v[nx][ny]) {
                    if (map[nx][ny] == 'P') {
                        answer++;
                    }

                    v[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return answer;
    }

    static boolean outOfMap(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}
