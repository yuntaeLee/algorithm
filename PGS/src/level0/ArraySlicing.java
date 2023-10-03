package level0;

import java.util.Arrays;

public class ArraySlicing {
    
    public static void main(String[] args) {
        int n = 4;
        int[] slicer = {1, 5, 2};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] actual = solution(n, slicer, nums);

        int[] expected = {2, 4, 6};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int n, int[] slicer, int[] nums) {
        int start = (n == 1) ? 0 : slicer[0];
        int end = (n == 2) ? nums.length - 1 : slicer[1];
        int interval = (n == 4) ? slicer[2] : 1;
        
        int[] answer = new int[(end - start) / interval + 1];
        int idx = 0;
        for (int i = start; i <= end; i += interval) {
            answer[idx++] = nums[i];
        }
        
        return answer;
    }
}
