package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScore {
    
    public static void main(String[] args) {
        String[] name = {"kali", "mari", "don"};
        int[] yearning = {11, 1, 55};
        String[][] photo = {
            {"kali", "mari", "don"}, 
            {"pony", "tom", "teddy"}, 
            {"con", "mona", "don"}};
        
        int[] actual = solution(name, yearning, photo);

        int[] expected = {67, 0, 55};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scores = new HashMap<>();
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < name.length; i++) {
            scores.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                String key = photo[i][j];
                
                if (scores.containsKey(key)) {
                    answer[i] += scores.get(key);
                }
            }
        }
        
        return answer;
    }
}
