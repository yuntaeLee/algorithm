package level0;

import java.util.HashMap;
import java.util.Map;

public class StringTying {

    static int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : strArr) {
            map.put(s.length(), map.getOrDefault(s.length(), 0) + 1);
        }
        
        int answer = 0;
        for (int key : map.keySet()) {
            answer = Math.max(answer, map.get(key));
        }
        
        return answer;
    }
}
