package level0;

import java.util.Arrays;

public class ChangeOrder {

    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 7, 5};
        int n = 3;

        int[] actual = solution(nums, n);

        int[] expected = {7, 5, 5, 2, 1};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] nums, int n) {
        int[] answer = new int[nums.length];
        for (int i = n; i < nums.length; i++) {
            answer[i - n] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            answer[nums.length - n + i] = nums[i];
        }
        
        return answer;
    }
}
