package level0;

import java.util.HashMap;
import java.util.Map;

public class Mode {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 3, 3, 4}));
	}
	
	static int solution(int[] array) {
        int answer = 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int val : array) {
            int n = map.getOrDefault(val, 0) + 1;
            map.put(val, n);
            
            if (cnt < n) {
                cnt = n;
                answer = val;
            } else if (cnt == n) {
                answer = -1;
            }
        }
        
        return answer;
	}
}
