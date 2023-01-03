package level2;

public class CorrectBracket {

	public static void main(String[] args) {
		System.out.println(solution("(())()"));
	}
	
    static boolean solution(String s) {
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                cnt++;
                continue;
            }
            
            if (cnt-- == 0) {
                return false;
            }
        }
        
        return cnt == 0 ? true : false;
    }
}
