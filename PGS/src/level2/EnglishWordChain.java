package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnglishWordChain {

    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 3;

        int[] actual = solution(n, words);

        int[] expected = {3, 3};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int num = 0;
        
        for (int i = 1; i < words.length; i++) {
            char prevLast = words[i - 1].charAt(words[i - 1].length() - 1);
            set.add(words[i - 1]);
            
            if (set.contains(words[i]) || prevLast != words[i].charAt(0)) {
                num = i;
                break;
            }
        }
        
        return new int[] {
            (num != 0) ? (num % n) + 1 : 0,
            (num != 0) ? (num / n) + 1 : 0
        };
    }
}