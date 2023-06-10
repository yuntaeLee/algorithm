package level1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheHallOfFame1 {
    
    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        int[] actual = solution(k, score);

        int[] expected = {10, 10, 10, 20, 20, 100, 100};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int k, int[] score) {
        Queue<Integer> q = new PriorityQueue<>();
        int[] answer = new int[score.length];
        
        for (int i = 0; i < score.length; i++) {
            q.offer(score[i]);
            
            if (q.size() > k) {
                q.poll();
            }
            
            answer[i] = q.peek();
        }
        
        return answer;
    }
}
