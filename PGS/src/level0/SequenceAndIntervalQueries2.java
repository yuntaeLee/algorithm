package level0;

import java.util.Arrays;

public class SequenceAndIntervalQueries2 {
    
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}};

        int[] actual = solution(arr, queries);

        int[] expected = {3, 4, -1};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            int diff = Integer.MAX_VALUE;
            int n = -1;
            
            for (int j = s; j <= e; j++) {
                int d = arr[j] - k;
                if (k < arr[j] && d < diff) {
                    diff = d;
                    n = arr[j];
                }
            }
            
            answer[i] = n;
        }
        
        return answer;
    }
}
