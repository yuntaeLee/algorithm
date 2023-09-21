package level0;

public class AEmphasis {
    
    public static void main(String[] args) {
        String myString = "abstract algebra";

        String actual = solution(myString);

        String expected = "AbstrAct AlgebrA";
        System.out.println(actual.equals(expected));
    }

    static String solution(String myString) {
        return myString.toLowerCase().replace('a', 'A');
    }
}
