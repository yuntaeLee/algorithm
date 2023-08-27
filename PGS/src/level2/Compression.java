package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
public class TertiaryCompression {
=======
public class Compression {
>>>>>>> f45db2b ([1차] 압축: HashMap)

    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";

        List<Integer> actual = solution(msg);

        List<Integer> expected = List.of(20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34);
        System.out.println(actual.equals(expected));
    }
    
    static List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        int number = 27;
        for (int i = 0; i < msg.length(); i++) {
            StringBuilder temp = new StringBuilder();
            int index = 0;
            for (int j = i; j < msg.length(); j++) {
                temp.append(msg.charAt(j));
                if (!map.containsKey(temp.toString())) {
                    break;
                }
                
                index = map.get(temp.toString());
                i = j;
            }
            
            answer.add(index);
            map.put(temp.toString(), number++);
        }
        
        return answer;
    }
}
