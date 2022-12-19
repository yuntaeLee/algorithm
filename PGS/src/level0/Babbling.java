package level0;

public class Babbling {

	public static void main(String[] args) {
		
	}
	
	static int solution(String[] babbling) {
        String[] origin = {"aya", "ye", "woo", "ma"};
        String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"};
        int answer = 0;
        
        for (String b : babbling) {
            for (String r : repeat) {
                b = b.replace(r, "X");
            }
            
            for (String o : origin) {
                b = b.replace(o, "?");
            }
            
            int sign = 0;
            for (int i = 0; i < b.length(); i++) {
                if (!b.substring(i, i + 1).equals("?")) {
                    sign = 1;
                    break;
                }
            }
            
            if (sign == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
