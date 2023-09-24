package level0;

import java.util.Arrays;

public class ConvertingArray3 {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 100, 99, 98};
        int k = 3;

        int[] actual = solution(arr, k);

        int[] expected = {3, 6, 9, 300, 297, 294};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] arr, int k) {
        return Arrays.stream(arr).map(operand -> k % 2 == 0 ? operand + k : operand * k).toArray();
    }
}
