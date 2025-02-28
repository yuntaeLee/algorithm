package greedy2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2138 {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] current = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            current[i] = s1.charAt(i) - '0';
            target[i] = s2.charAt(i) - '0';
        }

        int[] current2 = Arrays.copyOf(current, n);
        current2[0] = 1 - current2[0];
        current2[1] = 1 - current2[1];

        int answer = solution(n, current, target);
        int answer2 = solution(n, current2, target);
        if (answer2 != -1) {
            answer2++;
        }
        
        if (answer == -1) {
            System.out.println(answer2);
            return;
        }

        if (answer2 == -1) {
            System.out.println(answer);
            return;
        }

        System.out.println(Math.min(answer, answer2));
    }

    private static int solution(int n, int[] current, int[] target) {
        int answer = 0;
        for (int i = 1; i < n; i++) {

            if (current[i - 1] != target[i - 1]) {
                answer++;

                current[i - 1] = 1 - current[i - 1];
                current[i] = 1 - current[i];

                if (i < n - 1) {
                    current[i + 1] = 1 - current[i + 1];
                }
            }
        }

        return current[n - 1] != target[n - 1] ? -1 : answer;
    }
}
