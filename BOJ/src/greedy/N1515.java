package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1515 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int index = 0;
        int answer = 0;
        while (answer++ <= 30000) {
            String temp = String.valueOf(answer);
            for (int i = 0; i < temp.length(); i++) {
                if (s.charAt(index) == temp.charAt(i)) {
                    index++;
                }

                if (index == s.length()) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }
}
