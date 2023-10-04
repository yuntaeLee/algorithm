package level0;

import java.util.Arrays;

public class LeftRight {
    
    public static void main(String[] args) {
        String[] strs = {"u", "u", "l", "r"};

        String[] actual = solution(strs);

        String[] expected = {"u", "u"};
        System.out.println(Arrays.equals(actual, expected));
    }

    static String[] solution(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            if ("l".equals(strs[i])) {
                return Arrays.copyOfRange(strs, 0, i);
            } else if ("r".equals(strs[i])) {
                return Arrays.copyOfRange(strs, i + 1, strs.length);
            }
        }

        return new String[] {};
    }
}
