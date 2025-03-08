package d800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PetyaAndStrings {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine().toLowerCase();
        String s2 = br.readLine().toLowerCase();

        int result = s1.compareTo(s2);
        if (result == 0) {
            System.out.println(0);
            return;
        }

        if (result < 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(1);
    }
}
