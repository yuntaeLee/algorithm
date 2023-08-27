package level2;

import java.util.ArrayList;
import java.util.List;

public class NewsClustering {
    
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        int actual = solution(str1, str2);

        int expected = 65536;
        System.out.println(actual == expected);
    }

    static int solution(String str1, String str2) {
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        
        List<String> list1 = grouping(str1.toLowerCase());
        List<String> list2 = grouping(str2.toLowerCase());
        
        for (String s : list1) {
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        for (String s : list2) {
            union.add(s);
        }
        
        return calculateJakard(intersection.size(), union.size());
    }

    static List<String> grouping(String s) {
        List<String> answer=  new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' && s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z') {
                answer.add(s.substring(i, i + 2));
            }
        }

        return answer;
    }

    static int calculateJakard(int intersection, int union) {
        final int JAKARD_CONSTANT = 65536;
        double jakard = 0;

        if (union == 0) {
            jakard = 1;
        } else {
            jakard = (double) intersection / (double) union;
        }

        return (int) (jakard * JAKARD_CONSTANT);
    }
}
