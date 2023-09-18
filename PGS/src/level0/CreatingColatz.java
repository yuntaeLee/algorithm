package level0;

import java.util.ArrayList;
import java.util.List;

public class CreatingColatz {
    
    public static void main(String[] args) {
        int n = 10;
        
        List<Integer> actual = solution(n);

        List<Integer> expected = List.of(10, 5, 16, 8, 4, 2, 1);
        System.out.println(actual.equals(expected));
    }

    static List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        answer.add(n);
        
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            
            answer.add(n);
        }
        
        return answer;
    }
}
