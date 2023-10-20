package level0;

import java.util.ArrayList;
import java.util.List;

public class CreateArray2 {

    public static void main(String[] args) {
        int l = 5;
        int r = 555;

        List<Integer> actual = solution(l, r);

        List<Integer> expected = List.of(5, 50, 55, 500, 505, 550, 555);
        System.out.println(actual.equals(expected));
    }
    
    static List<Integer> solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int n = l; n <= r; n++) {
            if (isContainsOnlyFive(n)) {
                list.add(n);
            }
        }
        
        if (list.isEmpty()) {
            list.add(-1);
        }
        
        return list;
    }
    
    static boolean isContainsOnlyFive(int n) {
        while (n > 0) {
            if (n % 5 != 0) {
                return false;
            }
            
            n /= 10;
        }
        
        return true;
    }
}
