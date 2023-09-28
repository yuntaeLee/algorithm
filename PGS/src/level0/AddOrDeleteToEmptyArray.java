package level0;

import java.util.ArrayList;
import java.util.List;

public class AddOrDeleteToEmptyArray {
    
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};

        List<Integer> actual = solution(arr, flag);

        List<Integer> expected = List.of(3, 3, 3, 3, 4, 4, 4, 4);
        System.out.println(actual.equals(expected));
    }

    static List<Integer> solution(int[] arr, boolean[] flag) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    answer.add(arr[i]);
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    answer.remove(answer.size() - 1);
                }
            }
        }
        
        return answer;
    }
}
