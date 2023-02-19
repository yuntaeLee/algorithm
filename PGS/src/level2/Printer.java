package level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
		
        int result = 5;
		
        System.out.println(result == solution(priorities, location));
    }
	
    static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities) {
            pq.offer(p);
        }
        
        int answer = 0;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        return ++answer;
                    }

                    pq.poll();
                    answer++;    
                }
            }
        }
        
        return -1;
    }
}
