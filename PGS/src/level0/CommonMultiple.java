package level0;

public class CommonMultiple {
    
    public static void main(String[] args) {
        int number = 60;
        int n = 2;
        int m = 3;

        int actual = solution(number, n, m);

        int expected = 1;
        System.out.println(actual == expected);
    }

    static int solution(int number, int n, int m) {
        return number % n == 0 && number % m == 0 ? 1 : 0;
    }
}
