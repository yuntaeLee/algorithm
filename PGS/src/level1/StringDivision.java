package level1;

public class StringDivision {
    
    public static void main(String[] args) {
        String s = "aaabbaccccabba";

        int actual = solution(s);

        int expected = 3;
        System.out.println(actual == expected);
    }

    static int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int diff = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (diff == 0) {
                answer++;
                x = s.charAt(i);
            }
            
            if (x == s.charAt(i)) {
                diff++;
            } else {
                diff--;
            }
        }
        
        return answer + 1;
    }
}
