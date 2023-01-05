package level2;

public class ExpressionOfNumber {

	public static void main(String[] args) {
		int result = 4;
		System.out.println(result == solution(15));
	}
	
    static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int max = 0;
        int min = 0;
        
        while (max != n) {
            if (sum < n) {
                sum += ++max;
                continue;
            }
            
            if (sum == n) {
                answer++;
            }
            
            sum -= ++min;
        }
        
        return answer + 1;
    }
}
