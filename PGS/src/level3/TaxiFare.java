package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaxiFare {

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

    static List<List<Node>> graph;
    static final int INF = 20000001;
    
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {
            {4, 1, 10},
            {3, 5, 24},
            {5, 6, 2},
            {3, 1, 41},
            {5, 1, 24},
            {4, 6, 50},
            {2, 4, 66},
            {2, 3, 22},
            {1, 6, 25}
        };

        int actual = solution(n, s, a, b, fares);

        int expected = 82;
        System.out.println(actual == expected);
    }

    static int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] arr : fares) {
            graph.get(arr[0]).add(new Node(arr[1], arr[2]));
            graph.get(arr[1]).add(new Node(arr[0], arr[2]));
        }

        int answer = INF;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dijkstra(s, i) + dijkstra(i, a) + dijkstra(i, b));
        }

        return answer;
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[graph.size() + 1];
        
        for (int i = 1; i <= graph.size(); i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        pq.offer(new Node(start, 0));

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
