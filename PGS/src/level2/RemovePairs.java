package level2;

import java.util.Stack;

public class RemovePairs {

	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
	}
	
	static int solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stk.isEmpty() && stk.peek() == c) {
                stk.pop();
                continue;
            }
            
            stk.push(c);
        }
        
        return stk.size() == 0 ? 1 : 0;
    }
}
