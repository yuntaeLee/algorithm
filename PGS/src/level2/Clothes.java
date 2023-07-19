package level2;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    
    public static void main(String[] args) {
        String[][] clothes = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };

        int actual = solution(clothes);

        int expected = 5;
        System.out.println(actual == expected);
    }

    static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        
        return answer - 1;
    }
}
