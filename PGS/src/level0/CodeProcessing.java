package level0;

public class CodeProcessing {
    
    public static void main(String[] args) {
        String code = "abc1abc1abc";

        String actual = solution(code);

        String expected = "acbac";
        System.out.println(actual.equals(expected));
    }

    static String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '1') {
                mode = mode == 0 ? 1 : 0;
                continue;
            }

            if (i % 2 == mode) {
                answer.append(c);
            }
        }
        
        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}
