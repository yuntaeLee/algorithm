package level3;

import java.util.Arrays;

public class LockAndKey {
    
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        boolean actual = solution(key, lock);

        boolean expected = true;
        System.out.println(actual == expected);
    }

    static boolean solution(int[][] key, int[][] lock) {
        int keyLen = key.length;
        int lockLen = lock.length;
        int len = lockLen + (keyLen - 1) * 2;
        int[][] map = new int[len][len];
        
        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                map[i + keyLen - 1][j + keyLen - 1] = lock[i][j];
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (isMatch(map, key, lockLen)) {
                return true;
            }
            
            key = rotate(key);
        }
        
        return false;
    }

    static boolean isMatch(int[][] map, int[][] key, int lockLen) {
        int mapLen = map.length;
        int keyLen = key.length;
        int[][] copyMap = copy(map);
        
        for (int i = 0; i < mapLen - keyLen + 1; i++) {
            for (int j = 0; j < mapLen - keyLen + 1; j++) {
                copyMap = addKeyToMap(copyMap, key, i, j);
                
                if (areAllOne(copyMap, keyLen, lockLen)) {
                    return true;
                }
                
                copyMap = copy(map);
            }
        }
        
        return false;
    }
    
    static int[][] rotate(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - i - 1] = arr[i][j];
            }
        }
        
        return result;
    }
    
    static boolean areAllOne(int[][] map, int keyLen, int lockLen) {
        for (int i = keyLen - 1; i < keyLen + lockLen - 1; i++) {
            for (int j = keyLen - 1; j < keyLen + lockLen - 1; j++) {
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }
                
        return true;
    }

    static int[][] addKeyToMap(int[][] map, int[][] key, int si, int sj) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                map[si + i][sj + j] += key[i][j];
            }
        }
        
        return map;
    }
    
    static int[][] copy(int[][] arr) {
        int n = arr.length;
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        
        return copy;
    }
}
