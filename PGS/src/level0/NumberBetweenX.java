package level0;

import java.util.Arrays;

public class NumberBetweenX {

    public static void main(String[] args) {
        String myString = "oxooxoxxox";

        int[] actual = solution(myString);

        int[] expected = {1, 2, 1, 0, 1, 0};
        System.out.println(Arrays.equals(actual, expected));
    }
    
    static int[] solution(String myString) {
        return Arrays.stream(myString.split("x", myString.length()))
            .mapToInt(x -> x.length())
            .toArray();
    }
}
