package level0;

import java.util.stream.IntStream;

public class FindTheNearestOne {
    
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1};
        int idx = 1;

        int actual = solution(arr, idx);

        int expected = 3;
        System.out.println(actual == expected);
    }

    static int solution(int[] arr, int idx) {
        return IntStream.range(idx, arr.length).filter(i -> arr[i] == 1).findFirst().orElse(-1);
    }
}
