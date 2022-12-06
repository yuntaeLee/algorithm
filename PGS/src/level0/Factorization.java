package level0;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Factorization {

	public static void main(String[] args) {
		int[] input = solution(420);
		int[] answer = {2, 3, 5, 7};
		
		boolean result = true;
		for (int i = 0; i < answer.length; i++) {
			if (input[i] != answer[i]) {
				result = false;
				break;
			}
		}
		
		System.out.println(result ? "Success" : "Fail");
	}

	static int[] solution(int n) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            while (n % i == 0) {
                n /= i;
                set.add(i);
            }
        }
        
        if (n != 1) {
            set.add(n);
        }
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
