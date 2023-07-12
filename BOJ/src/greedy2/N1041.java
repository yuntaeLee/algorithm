package greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1041 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long N = Long.parseLong(br.readLine());
        int[] dice = new int[6];
        long[] num = new long[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            Arrays.sort(dice);
            int answer = 0;
            for (int i = 0; i < 5; i++) {
                answer += dice[i];
            }
            System.out.println(answer);
            return;
        }

        // 1면 -> 5(N - 2) ^ 2 + 4(N - 2)
        // 2면 -> 8(N - 2) + 4
        // 3면 -> 4
        long answer = 0;
        num[1] = 8 * (N - 2) + 4;
        num[2] = 4;

        num[0] = 5 * (N - 2) * (N - 2) + 4 * (N - 2);
        long min = dice[0];
        for (int i = 0; i < 6; i++) {
            min = Math.min(min, dice[i]);
        }
        answer += num[0] * min;

        min = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) continue;

                min = Math.min(min, dice[i] + dice[j]);
            }
        }
        answer += num[1] * min;

        min = 0;
        for (int i = 0; i < 3; i++) {
            min += Math.min(dice[i], dice[5 - i]);
        }
        answer += num[2] * min;

        System.out.println(answer);
    }
}
