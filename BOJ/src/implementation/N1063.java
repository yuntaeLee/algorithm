package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1063 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            char[] kingPos = king.clone();
            char[] stonePos = stone.clone();

            move(command, kingPos);
            if (outOfRange(kingPos)) continue;

            if (Arrays.equals(kingPos, stonePos)) {
                move(command, stonePos);
                if (outOfRange(stonePos)) continue;
            }

            king = kingPos;
            stone = stonePos;
        }

        sb.append(king).append('\n').append(stone);
        System.out.println(sb.toString());
    }

    static boolean outOfRange(char[] next) {
        return next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8';
    }

    static void move(String command, char[] next) {
        switch (command) {
            case "R": next[0]++; break;
            case "L": next[0]--; break;
            case "T": next[1]++; break;
            case "B": next[1]--; break;
            case "RT": next[0]++; next[1]++; break;
            case "RB": next[0]++; next[1]--; break;
            case "LT": next[0]--; next[1]++; break;
            case "LB": next[0]--; next[1]--; break;
        }
    }
}
