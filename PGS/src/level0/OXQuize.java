package level0;

import java.util.Arrays;

public class OXQuize {

	public static void main(String[] args) {
		String[] quiz = {"19 - 6 = 13",
						 "5 + 66 = 71",
						 "5 - 15 = 63",
						 "3 - 1 = 2"};
		
		String result = Arrays.toString(solution(quiz));
		System.out.println(result);
	}
	
	static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            answer[i] = isCorrect(arr) ? "O" : "X";
        }
        
        return answer;
    }
    
    static boolean isCorrect(String[] arr) {
        int result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length - 3; i+=2) {
            result += Integer.parseInt(arr[i + 1]) * (arr[i].equals("+") ? 1 : -1);
        }
        
        return result == Integer.parseInt(arr[arr.length - 1]);
    }
}
