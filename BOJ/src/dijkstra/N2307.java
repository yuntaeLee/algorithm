package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N2307 {

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

    static final int INF = 50000001;

    static int N;
    static int[] parent;
    static List<List<Node>> graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        int answer = 0;
        int minDist = dijkstra(0, 0, true);
        for (int i = 2; i <= N; i++) {
            int dist = dijkstra(parent[i], i, false);
            answer = Math.max(answer, dist - minDist);

            if (dist == INF) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
    }

    static int dijkstra(int rs, int re, boolean isFirst) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[graph.size() + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.v == N) {
                return dist[N];
            }

            if (cur.cost > dist[cur.v]) continue;

            for (Node next : graph.get(cur.v)) {
                if (cur.v == rs && next.v == re) continue;

                if (dist[next.v] > dist[cur.v] + next.cost) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));

                    if (isFirst) {
                        parent[next.v] = cur.v;
                    }
                }
            }
        }

        return INF;
    }
}
