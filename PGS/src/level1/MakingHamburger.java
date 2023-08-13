package level1;

import java.util.Stack;

public class MakingHamburger {
    
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        int actual = solution(ingredient);

        int expected = 2;
        System.out.println(actual == expected);
    }

    static int solution(int[] ingredient) {
        Stack<Integer> stk = new Stack<>();
        int answer = 0;
        
        for (int n : ingredient) {
            stk.push(n);
            
            if (n == 1 && stk.size() >= 4) {
                int size = stk.size();
                if (stk.get(size - 4) == 1 && stk.get(size - 3) == 2 && stk.get(size - 2) == 3 && stk.get(size - 1) == 1) {
                    stk.pop();
                    stk.pop();
                    stk.pop();
                    stk.pop();
                    
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
