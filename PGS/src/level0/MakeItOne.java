package level0;

import java.util.Arrays;

public class MakeItOne {
    
    public static void main(String[] args) {
        int[] nums = {12, 4, 15, 1, 14};

        int actual1 = solution1(nums);
        int actual2 = solution2(nums);

        int expected = 11;
        System.out.println(actual1 == expected);
        System.out.println(actual2 == expected);
    }

    static int solution1(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            while (num != 1) {
                if (num % 2 == 1) {
                    num--;
                }
                
                num /= 2;
                answer++;
            }
        }
        
        return answer;
    }

    static int solution2(int[] nums) {
        return Arrays.stream(nums).map(i -> Integer.toBinaryString(i).length() - 1).sum();
    }
}
