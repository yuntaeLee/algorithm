package level0;

public class RemoveLetters {
    
    public static void main(String[] args) {
        String myString = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};

        String actual = solution(myString, indices);

        String expected = "programmers";
        System.out.println(actual.equals(expected));
    }

    static String solution(String myString, int[] indices) {
        StringBuilder answer = new StringBuilder();
        String[] tmp = myString.split("");

        for (int i : indices) {
            tmp[i] = "";
        }

        for (String x : tmp) {
            answer.append(x);
        }
        
        return answer.toString();
    }
}
