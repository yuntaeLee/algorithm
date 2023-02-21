package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickingTangerines {

    public static void main(String[] args) {
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 6;
		
        int result = 3;
		
        System.out.println(result == solution(k, tangerine));
    }

	static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));
        
        int answer = 0;
        for (int key : list) {
            k -= map.get(key);
            answer++;
            
            if (k <= 0) {
                return answer;    
            }
        }
        
        return -1;
    }
}
