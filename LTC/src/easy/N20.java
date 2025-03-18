package easy;

import java.util.Map;
import java.util.Stack;

public class N20 {
    
    public static void main(String[] args) {
        String input = "[";

        boolean output = isValid(input);

        boolean result = false;
        System.out.println(output == result);
        
    }

    static boolean isValid(String s) {
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty() || stack.pop() != map.get(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
