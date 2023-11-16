package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N20529 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] mbti = new String[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mbti[i] = st.nextToken();
            }

            int answer = Integer.MAX_VALUE;
outerLoop : for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        answer = Math.min(answer, calcualteDistance(mbti[i], mbti[j], mbti[k]));
                        if (answer == 0) {
                            break outerLoop;
                        }
                    }
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    static int calcualteDistance(String m1, String m2, String m3) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            distance += m1.charAt(i) != m2.charAt(i) ? 1 : 0;
            distance += m1.charAt(i) != m3.charAt(i) ? 1 : 0;
            distance += m2.charAt(i) != m3.charAt(i) ? 1 : 0;
        }

        return distance;
    }
}
