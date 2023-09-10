package level0;

import java.util.stream.IntStream;

public class OperationsBasedOnLength {
    
    public static void main(String[] args) {
        int[] num_list1 = {3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1};
        int[] num_list2 = {2, 3, 4, 5};

        // Case 1
        int actual1 = solution(num_list1);
        int expected1 = 51;
        System.out.println(actual1 == expected1);

        // Case 2
        int actual2 = solution(num_list2);
        int expected2 = 120;
        System.out.println(actual2 == expected2);
    }

    static int solution(int[] num_list) {
        IntStream stream = IntStream.of(num_list);
        if (num_list.length > 10) {
            return stream.sum();
        }
        
        return stream.reduce(1, (a, b) -> a * b);
    }
}
