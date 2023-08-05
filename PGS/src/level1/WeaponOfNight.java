package level1;

public class WeaponOfNight {
    
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;

        int actual = solution(number, limit, power);

        int expected = 21;
        System.out.println(actual == expected);
    }

    static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int n = 1; n <= number; n++) {
            int count = getDivisorCount(n);
            answer += count > limit ? power : count;
        }
        
        return answer;
    }
    
    static int getDivisorCount(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) count++;
            else if (number % i == 0) count += 2;
        }
        
        return count;
    }
}
