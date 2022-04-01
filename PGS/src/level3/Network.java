package level3;

public class Network {
	
	public int solution(int n, int[][] computers) {
        int answer = 0; 
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean[] dfs(int i, int[][] computers, boolean[] visited) {
        visited[i] = true;
        
        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && !visited[j]) {
                visited = dfs(j, computers, visited);
            }
        }
        
        return visited;
    }

	public static void main(String[] args) {
		
	}

}
