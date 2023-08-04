package level0;

import java.util.Arrays;

public class CountDown {
    
    public static void main(String[] args) {
        int start = 10;
        int end = 3;

        int[] actual = solution(start, end);

        int[] expected = {10, 9, 8, 7, 6, 5, 4, 3};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];
        int idx = 0;
        for (int i = start; i >= end; i--) {
            answer[idx++] = i;
        }
        return answer;
    }
}
