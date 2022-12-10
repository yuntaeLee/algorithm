package level0;

public class PolynomialAddition {

	public static void main(String[] args) {
		System.out.println(solution("3x + 2 + 100x + 12x + 3"));
	}
	
	static String solution(String polynomial) {
        String[] arr = polynomial.split(" ");
        int x = 0;
        int v = 0;
        
        for (int i = 0; i < arr.length; i+=2) {
            if (arr[i].contains("x")) {
                x += arr[i].length() == 1 ? 1 : Integer.parseInt(arr[i].substring(0, arr[i].length() - 1));
                continue;
            }
            
            v += Integer.parseInt(arr[i]);
        }
        
        StringBuilder answer = new StringBuilder();
        if (x != 0) {
            if (x > 1) {
                answer.append(x);
            }
            answer.append("x");
        }
        
        if (v != 0) {
            if (x != 0) {
                answer.append(" + ");
            }
            answer.append(v);
        }
        
        return answer.toString();
    }
}
