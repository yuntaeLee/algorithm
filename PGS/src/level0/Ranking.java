package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ranking {

	public static void main(String[] args) {
		String result = Arrays.toString(solution(new int[][] {{10, 20}, {10, 20}, {10, 20}, {10, 10}, {90, 100}}));
		System.out.println(result);
	}
	
	static int[] solution(int[][] score) {
        List<Integer> scores = new ArrayList<>();
        for (int[] s : score) {
            scores.add(s[0] + s[1]);
        }
        
        scores.sort(Comparator.reverseOrder());
        
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            answer[i] = scores.indexOf(score[i][0] + score[i][1]) + 1;
        }
        
        return answer;
    }

}
