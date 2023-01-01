package level2;

public class MakeJadenCaseString {

	public static void main(String[] args) {
		System.out.println(solution("3people Unfollowed Me"));
	}

    static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] arr = s.toLowerCase().split("");
        boolean isFirst = true;
        
        for (String str : arr) {
            answer.append(isFirst ? str.toUpperCase() : str);
            isFirst = str.equals(" ") ? true : false;
        }
        
        return answer.toString();
    }
}
