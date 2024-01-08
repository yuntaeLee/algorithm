package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N13413 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String s2 = br.readLine();

            int wbCnt = 0;
            int bwCnt = 0;

            for (int i = 0; i < N; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (s1.charAt(i) == 'W') wbCnt++;
                    else bwCnt++;
                }
            }

            sb.append(Math.max(wbCnt, bwCnt)).append('\n');
        }

        System.out.println(sb);
    }
}
