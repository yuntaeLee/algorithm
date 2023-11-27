package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2810 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = 1;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'L') {
                i += 1;
            }

            answer++;
        }

        System.out.println(answer > N ? N : answer);
    }
}
