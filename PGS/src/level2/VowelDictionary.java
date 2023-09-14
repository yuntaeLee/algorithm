package level2;

public class VowelDictionary {
    
    public static void main(String[] args) {
        String word = "EIO";

        int actual = solution(word);

        int expected = 1189;
        System.out.println(actual == expected);
    }

    static int solution(String word) {
        int[] x = new int[5];
        x[4] = 1;
        for (int i = 3; i >= 0; i--) {
            x[i] = x[i + 1] * 5 + 1;
        }
        
        int answer = word.length();
        for (int i = 0; i < word.length(); i++) {
            int index = getNumberOfVowel(word.charAt(i));
            answer += x[i] * index;
        }
        
        return answer;
    }
    
    static int getNumberOfVowel(char c) {
        if (c == 'A') return 0;
        if (c == 'E') return 1;
        if (c == 'I') return 2;
        if (c == 'O') return 3;
        return 4;
    }
}
