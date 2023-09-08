package level2;

import java.util.HashMap;
import java.util.Map;

public class DiscountOffer {
    
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount =  {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int actual = solution(want, number, discount);

        int expected = 3;
        System.out.println(actual == expected);
    }

    static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        int left = 0;
        for (int right = 10; right < discount.length; right++) {
            if (isPossible(wantMap, discountMap)) {
                answer++;
            }
            
            discountMap.put(discount[left], discountMap.getOrDefault(discount[left], 2) - 1);
            discountMap.put(discount[right], discountMap.getOrDefault(discount[right], 0) + 1);
            left++;
        }
        
        return isPossible(wantMap, discountMap) ? answer + 1 : answer;
    }
    
    static boolean isPossible(Map<String, Integer> want, Map<String, Integer> discount) {
        for (String key : want.keySet()) {
            if (want.get(key) > discount.getOrDefault(key, 0)) {
                return false;
            }
        }
        
        return true;
    }
}
