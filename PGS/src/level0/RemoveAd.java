package level0;

import java.util.Arrays;

public class RemoveAd {
    
    public static void main(String[] args) {
        String[] strArr = {"and","notad","abcd"};

        String[] actual = solution(strArr);

        String[] expected = {"and","abcd"};
        System.out.println(Arrays.equals(actual, expected));
    }

    static String[] solution(String[] strArr) {
        return Arrays.stream(strArr)
                    .filter(s -> !s.contains("ad"))
                    .toArray(String[]::new);
    }
}
