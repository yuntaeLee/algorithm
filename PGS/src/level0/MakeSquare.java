package level0;

import java.util.Arrays;

public class MakeSquare {

    public static void main(String[] args) {
        int[][] arr = {{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}};

        int[][] actual = solution(arr);

        int[][] expected = {{572, 22, 37, 0}, {287, 726, 384, 0}, {85, 137, 292, 0}, {487, 13, 876, 0}};
        System.out.println(Arrays.equals(actual, expected, Arrays::compare));
    }
    
    static int[][] solution(int[][] arr) {
        if (arr.length == arr[0].length) {
            return arr;
        }
        
        int length = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[length][length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[i][j] = arr[i][j];
            }
        }
        
        return answer;
    }
}
