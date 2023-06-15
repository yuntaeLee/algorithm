package level3;

import java.util.HashSet;
import java.util.Set;

public class BurstingBalloon {
    
    public static void main(String[] args) {
        int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};

        int actual = solution(a);

        int expected = 6;
        System.out.println(actual == expected);
    }

    static int solution(int[] a) {
        int leftMin = 1_000_000_001;
        int rightMin = 1_000_000_001;
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            leftMin = Math.min(leftMin, a[i]);
            rightMin = Math.min(rightMin, a[a.length - 1 - i]);
            
            set.add(leftMin);
            set.add(rightMin);
        }
        
        return set.size();
    }
}
