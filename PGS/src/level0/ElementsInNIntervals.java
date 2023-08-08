package level0;

import java.util.Arrays;

public class ElementsInNIntervals {
    
    public static void main(String[] args) {
        int[] num_list = {4, 2, 6, 1, 7, 6};
        int n = 2;

        int[] actual = solution(num_list, n);

        int[] expected = {4, 6, 7};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] num_list, int n) {
        int length = num_list.length % n > 0 ? num_list.length / n + 1 : num_list.length / n;
        int[] answer = new int[length];
        int idx = 0;
        for (int i = 0; i < num_list.length; i += n) {
            answer[idx++] = num_list[i];
        }
        
        return answer;
    }
}
