package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1246 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] P = new int[M];

        for (int i = 0; i < M; i++) {
            P[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(P);

        int max = -1;
        int maxPrice = -1;
        for (int i = 0; i < M; i++) {
            int count = M - i;
            if (count > N) {
                count = N;
            }

            if (maxPrice < P[i] * count) {
                max = P[i];
                maxPrice = P[i] * count;
            }
        }

        sb.append(max).append(' ').append(maxPrice);
        System.out.println(sb.toString());
    }
}
