package level0;

import java.util.ArrayList;
import java.util.List;

public class CreateArray5 {
    
    public static void main(String[] args) {
        String[] intStrs = {"0123456789","9876543210","9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;

        List<Integer> actual = solution(intStrs, k, s, l);

        List<Integer> expected = List.of(56789, 99999);
        System.out.println(actual.equals(expected));
    }

    static List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        for (String str : intStrs) {
            int v = Integer.parseInt(str.substring(s, s + l));
            if (v > k) {
                answer.add(v);
            }            
        }
        
        return answer;
    }
}
