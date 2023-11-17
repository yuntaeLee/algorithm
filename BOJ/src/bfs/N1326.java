package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1326 {

    static class Bridge {
        int idx;
        int num;

        Bridge(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs(a, b));
    }

    static int bfs(int start, int end) {
        Queue<Bridge> q = new LinkedList<>();
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(new Bridge(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Bridge cur = q.poll();
            if (cur.idx == end) {
                return cur.num;
            }

            // 뒤
            for (int i = cur.idx; i >= 0; i -= arr[cur.idx]) {
                int next = cur.num + 1;
                if (next < dist[i]) {
                    dist[i] = next;
                    q.offer(new Bridge(i, next));
                }
            }
            
            // 앞
            for (int i = cur.idx; i < N; i += arr[cur.idx]) {
                int next = cur.num + 1;
                if (next < dist[i]) {
                    dist[i] = next;
                    q.offer(new Bridge(i, next));
                }
            }
        }

        return -1;
    }
}
