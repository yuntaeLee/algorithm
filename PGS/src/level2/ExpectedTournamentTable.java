package level2;

import sogang_contest.E;

public class ExpectedTournamentTable {
    
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;

        int s1Actual = solution1(n, a, b);
        int s2Actual = solution2(n, a, b);

        int expected = 3;
        System.out.println(s1Actual == expected || s2Actual == expected);
    }

    static int solution1(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        }

        return answer;
    }

    static int solution2(int n, int a, int b) {
        return Integer.toBinaryString((a - 1) ^ (b - 1)).length();
    }
}
