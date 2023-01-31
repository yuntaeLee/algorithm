package level1;

public class TheThreeMusketeers {
	static int answer = 0;
	static int sum = 0;

	public static void main(String[] args) {
		int[] input = {-3, -2, -1, 0, 1, 2, 3};
		int result = 5;
		
		bt(0, 0, input);
		
		System.out.println(result == answer);
	}

	static void bt(int depth, int start, int[] number) {
        if (depth == 3) {
            if (sum == 0) {
                answer++;
            }
            
            return;
        }
        
        for (int i = start; i < number.length; i++) {
            sum += number[i];
            bt(depth + 1, i + 1, number);
            sum -= number[i];
        }
    }
}
