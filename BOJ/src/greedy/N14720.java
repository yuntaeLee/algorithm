package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14720 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int milk = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int store = Integer.parseInt(st.nextToken());
            if (store == milk) {
                answer++;
                milk++;
                milk = milk > 2 ? 0 : milk;
            }
        }

        System.out.println(answer);
    }
}
