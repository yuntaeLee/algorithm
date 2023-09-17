package level0;

public class DiceGame1 {
    
    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        int actual = solution(a, b);

        int expected = 34;
        System.out.println(actual == expected);
    }

    static int solution(int a, int b) {
        int answer = 0;
        if (a % 2 != 0 && b % 2 != 0) {
            answer = (a * a) + (b * b);
        } else if (a % 2 != 0 || b % 2 != 0) {
            answer = 2 * (a + b);
        } else {
            answer = Math.abs(a - b);
        }
        
        return answer;
    }
}
