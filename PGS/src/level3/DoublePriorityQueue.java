package level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

	public static void main(String[] args) {
		
	}
	
	public int[] solution(String[] operations) {
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String oper : operations) {
            String[] arr = oper.split(" ");
            
            if (arr[0].equals("I")) {
                int n = Integer.parseInt(arr[1]);
                asc.offer(n);
                desc.offer(n);
            } else {
                if (desc.isEmpty()) continue;
                
                if (arr[1].equals("1")) {
                    int max = desc.peek();
                    desc.remove(max);
                    asc.remove(max);
                } else {
                    int min = asc.peek();
                    desc.remove(min);
                    asc.remove(min);
                }
            }
        }
        
        int[] answer = new int[2];
        if (!desc.isEmpty()) {
            answer = new int[] {desc.peek(), asc.peek()};
        }
        
        return answer;
    }
}
