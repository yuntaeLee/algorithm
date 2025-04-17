package medium;

public class N7 {

    public static void main(String[] args) {
        int input = -123;

        int result = -321;

        int output = reverse(input);
        System.out.println(output == result);
    }

    private static int reverse(int x) {
        long result = 0;

        while (x != 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }

        System.out.println(result);

        if (isOutOfIntRange(result)) {
            return 0;
        }

        return (int) result;
    }

    private static boolean isOutOfIntRange(long v) {
        return v < Integer.MIN_VALUE || Integer.MAX_VALUE < v;
    }
}
