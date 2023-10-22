package level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CutTheRollCake {
    
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};

        int actual = solution(topping);

        int expected = 2;
        System.out.println(actual == expected);
    }

    static int solution(int[] topping) {
        int answer = 0;
        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        left.add(topping[0]);
        for (int i = 1; i < topping.length; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 1; i < topping.length; i++) {
            left.add(topping[i]);
            right.put(topping[i], right.get(topping[i]) - 1);
            
            if (right.get(topping[i]) == 0) {
                right.remove(topping[i]);
            }
            
            if (left.size() == right.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
