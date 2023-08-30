package level2;

import java.util.Arrays;
import java.util.Comparator;

public class FileNameSorting {
    
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        String[] actual = solution(files);

        String[] expected = {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
        System.out.println(Arrays.equals(actual, expected));
    }

    static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                if (result == 0) {
                    result = convertNumber(o1.substring(head1.length())) - convertNumber(o2.substring(head2.length()));
                }
                
                return result;
            }
        });
        
        return files;
    }
    
    static int convertNumber(String str) {
        StringBuilder answer = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && answer.length() < 5) {
                answer.append(c);
                continue;
            }
            
            break;
        }
        
        return Integer.parseInt(answer.toString());
    }
}
