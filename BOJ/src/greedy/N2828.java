package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2828 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int answer = 0;
        int min = 1;
        int max = M;
        
        for (int i = 0; i < J; i++) {
            int pos = Integer.parseInt(br.readLine());
            if (pos < min) {
                answer += min - pos;
                min = pos;
                max = min + (M - 1);
            } else if (pos > max) {
                answer += pos - max;
                max = pos;
                min = max - (M - 1);
            }
        }

        System.out.println(answer);
    }
}
