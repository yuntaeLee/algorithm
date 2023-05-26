package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9370 {

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    
    static final int INF = 100000002;

    static int n;
    static List<List<Node>> graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) * 2;

                if ((a == g && b == h) || (a == h && b == g)) {
                    d--;
                }

                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                if (dijkstra(s, x) % 2 == 1) {
                    result.add(x);
                }
            }

            Collections.sort(result);
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int dijkstra(int start, int end) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.v == end) {
                return dist[cur.v];
            }

            if (cur.cost > dist[cur.v]) {
                continue;
            }

            for (Node next : graph.get(cur.v)) {
                if (dist[next.v] > dist[cur.v] + next.cost) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return INF;
    }
}
