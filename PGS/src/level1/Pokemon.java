package level1;

import java.util.HashSet;
import java.util.Set;

public class Pokemon {
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        int actual = solution(nums);

        int expected = 2;
        System.out.println(actual == expected);
    }

    static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        
        if (set.size() > nums.length / 2) {
            return nums.length / 2;
        }
        
        return set.size();
    }
}
