package greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N13975 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0;
            while (pq.size() > 1) {
                long v = pq.poll() + pq.poll();
                sum += v;
                pq.offer(v);
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }
}
