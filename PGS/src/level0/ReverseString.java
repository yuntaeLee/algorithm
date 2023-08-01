package level0;

public class ReverseString {
    
    public static void main(String[] args) {
        String my_string = "Progra21Sremm3";
        int s = 6;
        int e = 12;

        String actual = solution(my_string, s, e);

        String expected = "ProgrammerS123";
        System.out.println(actual.equals(expected));
    }

    static String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        StringBuilder target = new StringBuilder(my_string.substring(s, e + 1));
        return sb.replace(s, e + 1, target.reverse().toString()).toString();
    }
}
