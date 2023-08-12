package level1;

public class Babbling2 {
    
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        int actual = solution(babbling);

        int expected = 2;
        System.out.println(actual == expected);
    }

    static int solution(String[] babbling) {
        String[] filter = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String bab : babbling) {
            if(bab.contains("ayaaya") || bab.contains("yeye") || bab.contains("woowoo") || bab.contains("mama")) {
                continue;
            }

            for (String f : filter) {
                bab = bab.replace(f, " ");
            }
            
            bab = bab.replace(" ", "");
            if (bab.length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
