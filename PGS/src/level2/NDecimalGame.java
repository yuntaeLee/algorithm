package level2;

public class NDecimalGame {
    
    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 2;

        String actual = solution(n, t, m, p);

        String expected = "13579BDF01234567";
        System.out.println(actual.equals(expected));
    }
    
    static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder convert = new StringBuilder();
        
        for (int i = 0; convert.length() <= t * m; i++) {
            convert.append(Integer.toString(i, n));
        }
        
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(convert.charAt(i));
        }
        
        return answer.toString().toUpperCase();
    }
}
