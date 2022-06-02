package medium;

public class N5 {

	public static void main(String[] args) {
		String[] s = {"babad", "cbbd", "a"};
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(longestPalindrome(s[i]));
		}
		
	}
	
//	static String longestPalindrome(String s) {
//        String ans = "";
//        int len = 0;
//        
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if (j - i < len) continue;
//                
//                String ss = s.substring(i, j + 1);
//                
//                if (isPalindrome(ss)) {
//                    ans = ss;
//                    len = ss.length();
//                }
//            }
//        }
//        
//        return ans;
//    }
//    
//    static boolean isPalindrome(String s) {
//        int forward = 0;
//        int backward = s.length() - 1;
//        
//        while (backward > forward) {
//            if (s.charAt(forward++) != s.charAt(backward--))
//                return false;
//        }
//        
//        return true;
//    }
	
	static String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
			
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		
		return s.substring(start, end + 1);
	}
	
	static int expand(String s, int L, int R) {
		while (L >= 0 && R < s.length() && s.charAt(R) == s.charAt(L)) {
			L--;
			R++;
		}
		
		return R - L - 1;
	}
}
