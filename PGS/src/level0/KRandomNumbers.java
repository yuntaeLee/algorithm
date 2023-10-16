package level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class KRandomNumbers {
    
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 2, 3};
        int k = 3;

        int[] actual = solution(arr, k);

        int[] expected = {0, 1, 2};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] arr, int k) {
        return IntStream
                .concat(Arrays.stream(arr).distinct(), 
                        IntStream.range(0, k).map(i -> -1))
                .limit(k).toArray();
    }
}
