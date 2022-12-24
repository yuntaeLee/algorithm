package level1;

import java.util.Arrays;

public class TheNearestIdenticalLetter {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("banana")));
	}
	
    static int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] idx = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            answer[i] = idx[c] == 0 ? -1 : i - idx[c] + 1;
            idx[c] = i + 1;
        }
        
        return answer;
    }
}
