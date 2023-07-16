package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1343 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(poliomino(s));
    }

    static String poliomino(String s) {
        s = s.replaceAll("XXXX", "AAAA");
        s = s.replaceAll("XX", "BB");

        if (s.contains("X")) {
            return "-1";
        }

        return s;
    }
}
