package level2;

import java.util.Arrays;

public class CropSquaredArrayOfN {
    
    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;

        int[] actual = solution(n, left, right);

        int[] expected = {4, 3, 3, 3, 4, 4, 4, 4};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int n, long left, long right) {
        int length = (int) (right - left) + 1;
        int[] answer = new int[length];
        
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[idx++] = Math.max((int) row, (int) col) + 1;
        }
        
        return answer;
    }
}
