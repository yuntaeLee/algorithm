package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectTheIslands {
	
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        
        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = { {0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8} };
		
		int result = 4;
		System.out.println(solution(n, costs) == result);
	}
    
    static int solution(int n, int[][] costs) {
    	List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < costs.length; i++) {
            graph.get(costs[i][0]).add(new Node(costs[i][1], costs[i][2]));
            graph.get(costs[i][1]).add(new Node(costs[i][0], costs[i][2]));
        }
                
        return prim(graph, 0);
    }
    
    private static int prim(List<List<Node>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        int total = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.to;
            int cost = cur.cost;
            
            if (visited[v]) continue;
            
            visited[v] = true;
            total += cost;
            
            for (Node next : graph.get(v)) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }
        
        return total;
    }

}
