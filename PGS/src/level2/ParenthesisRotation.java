package level2;

import java.util.Stack;

public class ParenthesisRotation {
    
    public static void main(String[] args) {
        String s = "}]()[{";

        int actual = solution(s);

        int expected = 2;
        System.out.println(actual == expected);
    }

    static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isBracket(s)) {
                answer++;
            }
            s = s.substring(1, s.length()) + s.charAt(0);
        }
        
        return answer;
    }

    static boolean isBracket(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (stk.isEmpty()) {
                stk.push(c);
            } else if (c == ')' && stk.peek() == '(') {
                stk.pop();
            } else if (c == '}' && stk.peek() == '{') {
                stk.pop();
            } else if (c == ']' && stk.peek() == '[') {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        
        return stk.isEmpty();
    }
}
