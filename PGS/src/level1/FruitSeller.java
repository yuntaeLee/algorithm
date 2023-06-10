package level1;

import java.util.Arrays;

public class FruitSeller {
    
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        int actual = solution(k, m, score);

        int expected = 33;
        System.out.println(actual == expected);
    }

    static int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for (int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m;
        }
        
        return answer;
    }
}
