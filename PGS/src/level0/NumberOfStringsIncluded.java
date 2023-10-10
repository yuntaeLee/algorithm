package level0;

public class NumberOfStringsIncluded {
    
    public static void main(String[] args) {
        String myString = "banana";
        String pat = "ana";

        int actual = solution(myString, pat);

        int expected = 2;
        System.out.println(actual == expected);
    }

    static int solution(String myString, String pat) {
        int answer = 0;
        for (int i = 0; i < myString.length() - pat.length() + 1; i++) {
            String str = myString.substring(i);
            if (str.startsWith(pat)) {
                answer++;
            }
        }
        
        return answer;
    }
}
