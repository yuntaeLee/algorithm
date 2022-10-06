package level0;

import java.util.Arrays;

public class MakeMaxValue2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, -3, 4, 5}));
	}
	
	static int solution(int[] numbers) {
        Arrays.sort(numbers);
        
        if (numbers[numbers.length - 1] * numbers[numbers.length - 2] > numbers[0] * numbers[1]) {
            return numbers[numbers.length - 1] * numbers[numbers.length - 2];
        }
        
        return numbers[0] * numbers[1];
    }
}
