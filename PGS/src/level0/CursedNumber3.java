package level0;

public class CursedNumber3 {

	public static void main(String[] args) {

	}
	
	static int solution(int n) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (++answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }
        
        return answer;
    }
}
