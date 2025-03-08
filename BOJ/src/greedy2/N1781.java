package greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1781 {

    static class CupRamen implements Comparable<CupRamen> {
        int deadline;
        int count;

        CupRamen(int deadline, int count) {
            this.deadline = deadline;
            this.count = count;
        }

        @Override
        public int compareTo(CupRamen o) {
            if (deadline == o.deadline) {
                return o.count - count;
            }

            return deadline - o.deadline;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<CupRamen> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            list.add(new CupRamen(deadline, count));
        }

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            CupRamen c = list.get(i);

            if (pq.size() < c.deadline) {
                pq.offer(c.count);
                continue;
            }

            pq.offer(Math.max(c.count, pq.poll()));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
