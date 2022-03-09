package level1;

public class TernaryFlipping {
	
	public int solution(int n) {
		
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        int pow = sb.length() - 1;

        for (int i = 0; i < sb.length(); i++) {
            int num = sb.charAt(i) - '0';
            answer += num * Math.pow(3, pow--);
        }

        return answer;
    }

	public static void main(String[] args) {
		
	}

}
