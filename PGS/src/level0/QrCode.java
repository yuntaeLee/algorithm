package level0;

public class QrCode {
    
    public static void main(String[] args) {
        int q = 3;
        int r = 1;
        String code = "qjnwezgrpirldywt";

        String actual = solution(q, r, code);

        String expected = "jerry";
        System.out.println(actual.equals(expected));
    }

    static String solution(int q, int r, String code) {
        StringBuilder answer = new StringBuilder();
        for (int i = r; i < code.length(); i += q) {
            if (i % q == r) {
                answer.append(code.charAt(i));
            }
        }
        
        return answer.toString();
    }
}
