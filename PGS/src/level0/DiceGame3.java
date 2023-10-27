package level0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceGame3 {
    
    public static void main(String[] args) {
        int actual = solution(6, 3, 3, 6);

        int expected = 27;
        System.out.println(actual == expected);
    }

    static int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> dice = new HashMap<>();
        dice.put(a, dice.getOrDefault(a, 0) + 1);
        dice.put(b, dice.getOrDefault(b, 0) + 1);
        dice.put(c, dice.getOrDefault(c, 0) + 1);
        dice.put(d, dice.getOrDefault(d, 0) + 1);
        
        List<Integer> keys = new ArrayList<>(dice.keySet());
        
        if (dice.size() == 1) {
            return 1111 * a;
        }
        
        if (dice.size() == 2) {
            if (dice.get(keys.get(0)) == 1 || dice.get(keys.get(1)) == 1) {
                int p = dice.get(keys.get(0)) == 3 ? keys.get(0) : keys.get(1);
                int q = dice.get(keys.get(0)) == 1 ? keys.get(0) : keys.get(1);
                return (int) Math.pow(10 * p + q, 2);
            }
            
            return (keys.get(0) + keys.get(1)) * Math.abs(keys.get(0) - keys.get(1));
        }
        
        if (dice.size() == 3) {
            int answer = 1;
            for (int key : keys) {
                if (dice.get(key) != 2) {
                    answer *= key;
                }
            }
            
            return answer;
        }
        
        Collections.sort(keys);
        return keys.get(0);
    }
}
