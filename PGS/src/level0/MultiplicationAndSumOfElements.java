package level0;

import java.util.Arrays;

public class MultiplicationAndSumOfElements {
    
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2, 1};

        int actual = solution(nums);

        int expected = 1;
        System.out.println(actual == expected);
    }
    
    static int solution(int[] nums) {
        int sumSquared = (int) Math.pow(Arrays.stream(nums).sum(), 2);
        int mul = Arrays.stream(nums).reduce(1, (x, y) -> x * y);
        return sumSquared > mul ? 1 : 0;
    }
}
