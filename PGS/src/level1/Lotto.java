package level1;

import java.util.Arrays;

public class Lotto {
    
    public static void main(String[] args) {
        int[] lotto = {44, 1, 0, 0, 31, 25};
        int[] wins = {31, 10, 45, 1, 6, 19};

        int[] actual = solution(lotto, wins);

        int[] expected = {3, 5};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] lottos, int[] wins) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int[] answer = new int[2];
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                answer[0]++;
                continue;
            }
            
            for (int win : wins) {
                if (lotto == win) {
                    answer[0]++;
                    answer[1]++;
                    break;
                }
            }
        }
        
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        
        return answer;
    }
}
