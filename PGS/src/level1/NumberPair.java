package level1;

public class NumberPair {
    
    public String solution(String X, String Y) {
        int[] temp = new int[10];
        int[] count = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            int n = X.charAt(i) - '0';
            temp[n]++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int n = Y.charAt(i) - '0';
            if (temp[n] > 0) {
                temp[n]--;
                count[n]++;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < count[i]; j++) {
                answer.append(i);
            }
        }
        
        if (answer.length() == 0) {
            return "-1";
        }
        
        return answer.toString().charAt(0) == '0' ? "0" : answer.toString();
    }
}
