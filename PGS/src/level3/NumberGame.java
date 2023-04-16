package level3;

import java.util.Arrays;

public class NumberGame {
    
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        int result = 3;
        System.out.println(result == solution(A, B));
    }

    static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        for (int i = 0; i < B.length; i++) {
            if (A[idx] < B[i]) {
                answer++;
                idx++;
            }
        }
        
        return answer;
    }
}