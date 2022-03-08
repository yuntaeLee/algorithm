package level1;

public class CasesarCipher {
	
	public String solution(String s, int n) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }

            else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            }
            
            answer += ch;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
	}

}
