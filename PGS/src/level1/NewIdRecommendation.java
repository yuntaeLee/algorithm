package level1;

public class NewIdRecommendation {

    public static void main(String[] args) {
        String newId = "...!@BaT#*..y.abcdefghijklm";

        String actual = solution(newId);

        String expected = "bat.y.abcdefghi";
        System.out.println(actual.equals(expected));
    }    

    static String solution(String newId) {
        String answer = newId.toLowerCase();

        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        if (answer.equals("")) {
            answer += "a";
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$","");
        }

        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }

        return answer;
    }
}
