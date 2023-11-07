package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N1417 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N - 1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (!pq.isEmpty() && d <= pq.peek()) {
            pq.offer(pq.poll() - 1);
            answer++;
            d++;
        }

        System.out.println(answer);
    }
}
