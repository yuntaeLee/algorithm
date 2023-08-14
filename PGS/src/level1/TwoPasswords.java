package level1;

public class TwoPasswords {
    

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (skip.indexOf(temp) == -1) {
                    idx += 1;
                }
            }
            
            answer.append(temp);
        }

        return answer.toString();
    }
}
