package level0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrderOfTreatment {

	public static void main(String[] args) {
		int[] order = solution(new int[] {30, 10, 23, 6, 100});
		for (int val : order) System.out.print(val + " ");
	}
	
	static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] copy = emergency.clone();
        
        Arrays.sort(copy);
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = emergency.length;
        
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i], rank--);
        }
        
        for (int i = 0; i < emergency.length; i++) {
            answer[i] = map.get(emergency[i]);
        }
        
        return answer;
    }

}
