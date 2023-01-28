package level2;

import java.util.Stack;

public class CourierBox {

	public static void main(String[] args) {
		int[] input = {4, 3, 1, 2, 5};
		int result = 2;
		
		System.out.println(result == solution(input));
	}
	
	static int solution(int[] order) {
        Stack<Integer> stk = new Stack<>();
        int answer = 0;
        int idx = 0;
        
        for (int box = 1; box <= order.length; box++) {
            if (box != order[idx]) {
                stk.push(box);
                continue;
            }
            
            answer++;
            idx++;
            
            while (!stk.isEmpty()) {
                if (stk.peek() != order[idx]) {
                    break;
                }
                
                stk.pop();
                idx++;
                answer++;
            }
        }
        
        return answer;
    }
}
