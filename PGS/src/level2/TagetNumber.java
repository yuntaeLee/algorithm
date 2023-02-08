package level2;

public class TagetNumber {
	
	static int answer;
	static int N;

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		N = numbers.length;
		
		int result = 5;
		
		System.out.println(result == dfs(0, 0, numbers, target));
	}
	
	static int dfs(int depth, int sum, int[] numbers, int target) {
		if (depth == N) {
		    if (sum == target) {
			answer++;
			return 1;
		    }

		    return 0;
		}    
        
        	return dfs(depth + 1, sum + numbers[depth], numbers, target) + dfs(depth + 1, sum - numbers[depth], numbers, target);
	}
}
