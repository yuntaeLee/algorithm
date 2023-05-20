package level4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Caving {

    static int[] prev;
    static int[] save;
    static List<List<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) {
        int n = 9;
        int[][] path = {{0,1}, {0,3}, {0,7}, {8,1}, {3,6}, {1,2}, {4,7}, {7,5}};
        int[][] order = {{4,1}, {5,2}};

        boolean actual = solution(n, path, order);

        boolean expected = true;
        System.out.println(actual == expected);
    }

    static boolean solution(int n, int[][] path, int[][] order) {
        prev = new int[n];
        save = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] arr : path) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        
        for (int[] arr : order) {
            prev[arr[1]] = arr[0];
        }
        
        if (prev[0] != 0) {
            return false;
        }
        
        return bfs(n);
    }
    
    static boolean bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n];
        q.offer(0);
        v[0] = true;
        
        for (int node : graph.get(0)) {
            q.offer(node);
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (v[cur]) continue;
            
            if (!v[prev[cur]]) {
                save[prev[cur]] = cur;
                continue;
            }
            
            v[cur] = true;
            for (int next : graph.get(cur)) {
                q.offer(next);
            }
            
            q.offer(save[cur]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!v[i]) return false;
        }
        
        return true;
    }
}
