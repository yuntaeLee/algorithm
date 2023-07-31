package level0;

public class VerticalReading {
    
    public static void main(String[] args) {
        String my_string = "ihrhbakrfpndopljhygc";
        int m = 4;
        int c = 2;
        
        String actual = solution(my_string, m, c);

        String expected = "happy";
        System.out.println(actual.equals(expected));
    }

    static String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();
        for (int i = c - 1; i < my_string.length(); i += m) {
            answer.append(my_string.charAt(i));    
        }
        return answer.toString();
    }
}
