package level0;

public class NCharactersBeforeString {
    
    public static void main(String[] args) {
        String my_string = "ProgrammerS123";
        int n = 11;

        String actual = solution(my_string, n);

        String expected = "ProgrammerS";
        System.out.println(actual.equals(expected));
    }

    static String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }
}
