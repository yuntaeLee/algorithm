package level0;

public class SafeZone {
	
	static int n;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};

	public static void main(String[] args) {
		
	}
    
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 0 && isSafe(x, y, board)) {
                    answer++;
                }
            } 
        }
        
        return answer;
    }
    
    static boolean isSafe(int x, int y, int[][] board) {
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (outOfBoard(nx, ny)) continue;
            
            if (board[nx][ny] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    static boolean outOfBoard(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}
