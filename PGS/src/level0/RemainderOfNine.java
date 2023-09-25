package level0;

public class RemainderOfNine {

    public static void main(String[] args) {
        String number = "78720646226947352489";

        int actual = solution(number);

        int expected = 2;
        System.out.println(actual == expected);
    }
    
    static int solution(String number) {
        return number.chars().map(c -> (c - '0') % 9).sum() % 9;
    }
}
