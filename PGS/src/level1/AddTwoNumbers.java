package level1;

import java.util.TreeSet;

public class AddTwoNumbers {
	
	public int[] solution(int[] numbers) {
        int[] answer = {};
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        answer = new int[set.size()];
        int idx = 0;
        
        for (int e : set) {
            answer[idx++] = e;
        }
        
        return answer;
    }

	public static void main(String[] args) {

	}

}
