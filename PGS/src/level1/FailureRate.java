package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FailureRate {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] actual = solution(N, stages);

        int[] expected = {3, 4, 2, 1, 5};
        System.out.println(Arrays.equals(actual, expected));
    }
    
    static int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            double total = 0;
            double fail = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i <= stages[j]) total++;
                if (i == stages[j]) fail++;
            }
            
            double value = total == 0 && fail == 0 ? fail : fail/total;
            map.put(i, value);
        }
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            double max = -1;
            int removeKey = 0;
            for (int key : map.keySet()) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    removeKey = key;   
                }
            }
            
            answer[i] = removeKey;
            map.remove(removeKey);
        }
        
        return answer;
    }
}
