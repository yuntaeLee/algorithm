package level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FurthestNode {

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		System.out.println(solution(n, edge));
	}
	
	static int solution(int n, int[][] edge) {
		List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] arr : edge) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        
        int[] dist = new int[n + 1];
        bfs(graph, dist, 1);
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) answer++;
        }
        
        return answer;
	}
	
	static void bfs(List<List<Integer>> graph, int[] dist, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph.get(cur)) {
                if (dist[next] == 0) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }       
            }
        }
    }
}
