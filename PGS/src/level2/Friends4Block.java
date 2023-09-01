package level2;

public class Friends4Block {
    
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        int actual = solution(m, n, board);

        int expected = 15;
        System.out.println(actual == expected);
    }

    static final char BLANK = ' ';
    
    static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = initMap(board, m, n);
        
        while(true) {
			int count = getCountOfDestroyedBlocks(map, m, n);
			if(count == 0) break;
			answer += count;
			
			dropBlock(map, m, n);
		}
		
		return answer;
    }
    
    static void dropBlock(char[][] map, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                
                if (map[i][j] == BLANK) {
                    int k = i;
                    while (k > 0 && map[k][j] == BLANK) {
                        k--;
                    }
                    
                    if (map[k][j] != BLANK) {
                        map[i][j] = map[k][j];
                        map[k][j] = BLANK;
                    }
                }
            }
        }
    }
    
    static int getCountOfDestroyedBlocks(char[][] map, int m, int n) {
        int count = 0;
        boolean[][] isDestroyed = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == BLANK) continue;
                checkDestroy(map, isDestroyed, i, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isDestroyed[i][j]) {
                    map[i][j] = BLANK;
                    count++;
                }
            }
        }
        
        return count;
    }
    
    static boolean checkDestroy(char[][] map, boolean[][] isDestroyed, int r, int c) {
        char block = map[r][c];
        if (map[r][c] == block && map[r][c + 1] == block && map[r + 1][c] == block && map[r + 1][c + 1] == block) {
            isDestroyed[r][c] = true;
            isDestroyed[r][c + 1] = true;
            isDestroyed[r + 1][c] = true;
            isDestroyed[r + 1][c + 1] = true;
            return true;
        }
        
        return false;
    }
    
    static char[][] initMap(String[] board, int m, int n) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        return map;
    }
}
