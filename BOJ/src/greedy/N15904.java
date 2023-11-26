package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N15904 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ucpc[idx]) {
                idx++;
            }

            if (idx == 4) {
                System.out.println("I love UCPC");
                return;
            }
        }

        System.out.println("I hate UCPC");
    }
}
