package level2;

import java.util.PriorityQueue;

public class MoreSpicy {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int actual = solution(scoville, K);

        int expected = 2;
        System.out.println(actual == expected);
    }
    
    static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;   
            }
            
            pq.offer(pq.poll() + pq.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}
