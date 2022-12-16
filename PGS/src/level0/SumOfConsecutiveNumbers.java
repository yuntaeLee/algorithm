package level0;

import java.util.Arrays;

public class SumOfConsecutiveNumbers {

	public static void main(String[] args) {
		String result = Arrays.toString(solution(5, 5));
		System.out.println(result);
	}
	
    static int[] solution(int num, int total) {
        int[] answer = new int[num];
        int check = num*(num+1) / 2;
        int start = (total - check) / num + 1;
        
        for (int i = 0; i < num; i++) {
                answer[i] = start + i ;
        }
        
        return answer;
    }
}
