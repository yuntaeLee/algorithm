package level0;

import java.util.Arrays;

public class CutStringToSort {
    
    public static void main(String[] args) {
        String myString = "dxccxbbbxaaaa";

        String[] actual = solution(myString);

        String[] expected = {"aaaa","bbb","cc","d"};
        System.out.println(Arrays.equals(actual, expected));
    }

    static String[] solution(String myString) {
        return Arrays.stream(myString.split("x"))
                    .filter(s -> !s.isEmpty())
                    .sorted()
                    .toArray(String[]::new);
    }
}
