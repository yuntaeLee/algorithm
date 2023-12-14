package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N19939 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;
        int min = (K + 1) * K / 2;

        if (min > N) {
            System.out.println(-1);
            return;
        }

        N -= min;
        answer = K - 1;
        if (N % K != 0) {
            answer++;
        }

        System.out.println(answer);
    }
}
