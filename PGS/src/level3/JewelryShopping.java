package level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JewelryShopping {
    
    public static void main(String[] args) {
        String[] gems = {"A", "B", "A", "B", "B", "A", "A", "C", "D", "A", "B"};

        int[] actual = solution(gems);

        int[] expected = {8, 11};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        
        int left = 0;
        int right = 0;
        int[] answer = new int[] {1, gems.length};
        Map<String, Integer> map = new HashMap<>();
        
        while (true) {
            if (map.size() == set.size()) {
                map.put(gems[left], map.get(gems[left]) - 1);
                
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;   
            }
            
            if (map.size() == set.size()) {
                if (answer[1] - answer[0] > right - (left + 1)) {
                    answer[0] = left + 1;
                    answer[1] = right;
                }        
            }
        }
        
        return answer;
    }
}
