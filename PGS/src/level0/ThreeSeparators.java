package level0;

import java.util.Arrays;

public class ThreeSeparators {
    
    public static void main(String[] args) {
        String myStr = "baconlettucetomato";

        String[] actual = solution(myStr);

        String[] expected = {"onlettu", "etom", "to"};
        System.out.println(Arrays.equals(actual, expected));
    }

    static String[] solution(String myStr) {
        String[] answer = Arrays.stream(myStr.split("[a-cA-C]")).filter(s -> s.length() != 0).toArray(String[]::new);
        return answer.length == 0 ? new String[] {"EMPTY"} : answer;
    }
}
