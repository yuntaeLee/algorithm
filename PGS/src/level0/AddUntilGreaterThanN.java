package level0;

public class AddUntilGreaterThanN {
    
    public static void main(String[] args) {
        int[] numbers = {34, 5, 71, 29, 100, 34};
        int n = 123;

        int actual = solution(numbers, n);

        int expected = 139;
        System.out.println(actual == expected);
    }

    static int solution(int[] numbers, int n) {
        int answer = 0;
        for (int num : numbers) {
            if (answer > n) {
                return answer;
            }
            answer += num;
        }
        
        return answer;
    }
}
