package level1;

public class SmallSubstring {

	public static void main(String[] args) {
		System.out.println(solution("500220839878", "7"));
	}
	
    static int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            if (isCorrect(t.substring(i, i + p.length()), p)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isCorrect(String t, String p) {
        return Long.parseLong(t) <= Long.parseLong(p);
    }
}
