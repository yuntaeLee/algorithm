package level0;

import java.util.Arrays;

public class PictureEnlargement {
    
    public static void main(String[] args) {
        String[] picture = {".xx...xx.", 
                            "x..x.x..x", 
                            "x...x...x", 
                            ".x.....x.", 
                            "..x...x..", 
                            "...x.x...", 
                            "....x...."};
        int k = 2;

        String[] actual = solution(picture, k);

        String[] expected = {"..xxxx......xxxx..",
                             "..xxxx......xxxx..", 
                             "xx....xx..xx....xx", 
                             "xx....xx..xx....xx", 
                             "xx......xx......xx", 
                             "xx......xx......xx", 
                             "..xx..........xx..", 
                             "..xx..........xx..", 
                             "....xx......xx....", 
                             "....xx......xx....", 
                             "......xx..xx......", 
                             "......xx..xx......", 
                             "........xx........", 
                             "........xx........"};
        System.out.println(Arrays.equals(actual, expected));
    }

    static String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int idx = 0;
        for (int i = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < picture[i].length(); j++) {
                sb.append(String.valueOf(picture[i].charAt(j)).repeat(k));
            }
            
            for (int j = 0; j < k; j++) {
                answer[idx++] = sb.toString();
            }
        }
        
        return answer;
    }
}
