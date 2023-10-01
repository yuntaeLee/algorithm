package level0;

public class FindTheLongestSubstringThatEndsWithSpecificString {
    
    public static void main(String[] args) {
        String myString = "AbCdEFG";
        String pat = "dE";

        String actual = solution(myString, pat);

        String expected = "AbCdE";
        System.out.println(actual.equals(expected));
    }

    static String solution(String myString, String pat) {
        return myString.substring(0, myString.lastIndexOf(pat) + pat.length());
    }
}
