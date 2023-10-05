package level0;

import java.util.Arrays;
import java.util.Stack;

public class CreateArray6 {
    
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0};

        int[] actual = solution(arr);

        int[] expected = {0, 1, 0};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int v : arr) {
            if (!stack.isEmpty() && v == stack.peek()) {
                stack.pop();
            } else {
                stack.push(v);
            }
        }

        return stack.isEmpty() ? new int[] { -1 } : stack.stream().mapToInt(i -> i).toArray();
    }
}
