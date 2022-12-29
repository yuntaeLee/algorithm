package level3;

import java.util.Arrays;

public class BestSet {

	public static void main(String[] args) {
		String result = Arrays.toString(solution(3, 11));
		System.out.println(result);
	}
	
    static int[] solution(int n, int s) {
        if (s < n) {
            return new int[] {-1};
        }
        
        int[] answer = new int[n];
        Arrays.fill(answer, s / n);
        for (int i = n - 1, sub = s % n; sub > 0; i--, sub--) {
            answer[i] += 1;
        }
        
        return answer;
    }
}
