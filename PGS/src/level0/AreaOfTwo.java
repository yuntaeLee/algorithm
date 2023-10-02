package level0;

import java.util.Arrays;

public class AreaOfTwo {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 10, 2, 1};

        int[] actual = solution(arr);

        int[] expected = {2, 1, 2, 1, 10, 2};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] arr) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                start = i;
                break;
            }
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                end = i;
                break;
            }
        }
        
        int[] answer = new int[end - start + 1];
        int idx = 0;
        for (int i = start; i <= end; i++) {
            answer[idx++] = arr[i];
        }
        
        if (answer.length == 1 && answer[0] != 2) {
            answer[0] = -1;
        }
        
        return answer;
    }
}
