package level2;

import java.util.Arrays;
import java.util.Stack;

public class FindTheBigNumbersBehind {
    
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};

        int[] actual = solution(numbers);

        int[] expected = {-1, 5, 6, 6, -1, -1};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
            while (!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
                answer[stk.pop()] = numbers[i];
            }
            
            stk.push(i);
        }
        
        while (!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }
        
        return answer;
    }
}
