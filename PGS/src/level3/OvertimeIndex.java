package level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class OvertimeIndex {

	public static void main(String[] args) {
		System.out.println(solution(4, new int[] {4, 3, 3}));
	}
	
	static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        
        while (n-- > 0) {
            pq.offer(pq.poll() - 1);         
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (num > 0) {
                answer += Math.pow(num, 2);    
            }
        }
        
        return answer;
    }
}
