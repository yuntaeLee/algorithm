package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateArray {
    
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};

        int[] actual = solution(arr);

        int[] expected = {1, 2, 3};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while (idx < arr.length) {
            if (list.isEmpty()) {
                list.add(arr[idx++]);
            } else if (list.get(list.size() - 1) < arr[idx]) {
                list.add(arr[idx++]);
            } else {
                list.remove(list.size() - 1);
            }
        }

        int[] stk = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            stk[i] = list.get(i);
        }
        
        return stk;
    }
}
