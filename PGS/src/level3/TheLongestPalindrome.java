package level3;

public class TheLongestPalindrome {
    
    public static void main(String[] args) {
        String s = "abacde";

        int actual = solution(s);

        int expected = 3;
        System.out.println(actual == expected);
    }

    static int solution(String s) {
        int answer = 0;
        int left = 0;
        int right = 1;
        
        if (s.length() == 1) {
            return 1;
        }
        
        while (right < s.length()) {
            if (isPalindrome(s, left, right)) {
                answer = Math.max(answer, right - left + 1);
                right++;
                left = 0;
                continue;
            }
            
            if (left == right) {
                right++;
                left = 0;
                continue;
            }
            
            left++;
        }
        
        return answer;
    }
    
    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        
        return true;
    }
}
