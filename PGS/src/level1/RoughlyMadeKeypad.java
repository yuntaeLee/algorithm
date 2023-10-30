package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RoughlyMadeKeypad {
    
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};

        int[] actual = solution(keymap, targets);

        int[] expected = {9, 4};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> keypad = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if (keypad.containsKey(c)) {
                    keypad.put(c, Math.min(keypad.get(c), j + 1));
                    continue;
                }
                
                keypad.put(c, j + 1);
            }
        }
        
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            boolean flag = true;
            
            for (char c : target.toCharArray()) {
                if (keypad.containsKey(c)) {
                    count += keypad.get(c);
                    continue;
                }
                
                flag = false;
                break;
            }
            
            answer[i] = !flag ? -1 : count;
        }
        
        return answer;
    }
}
