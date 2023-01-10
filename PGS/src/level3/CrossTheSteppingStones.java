package level3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CrossTheSteppingStones {
	
    static class QueueWithMax<T extends Comparable<T>> {
        Queue<T> queue;
        Deque<T> cMax;

        public QueueWithMax() {
            queue = new LinkedList<>();
            cMax = new LinkedList<>();
        }

        public void offer(T element) {
            queue.offer(element);
            while (!cMax.isEmpty() && element.compareTo(cMax.peekLast()) > 0) {
                cMax.pollLast();
            }
            cMax.offerLast(element);
        }

        public T poll() {
            if (cMax.peekFirst().equals(queue.peek()))
                cMax.pollFirst();
            return queue.poll();
        }

        public T getMax() {
            return cMax.peekFirst();
        }
    }

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		int result = 3;
		System.out.println(result == solution(stones, k));
	}
	
    static int solution(int[] stones, int k) {
        QueueWithMax<Integer> qm = new QueueWithMax<>();
        
        int answer = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (cnt == k) {
                answer = Math.min(answer, qm.getMax());
                qm.poll();
                cnt--;
            }
            
            qm.offer(stones[i]);
            cnt++;
        }
        
        return Math.min(answer, qm.getMax());
    }
}
