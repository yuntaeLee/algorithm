package level0;

import java.util.stream.IntStream;

public class ComparingArrays {
    
    public static void main(String[] args) {
        int[] arr1 = {100, 17, 84, 1};
        int[] arr2 = {55, 12, 65, 36};

        int actual = solution(arr1, arr2);

        int expected = 1;
        System.out.println(actual == expected);
    }

    static int solution(int[] arr1, int[] arr2) {
        int answer = Integer.compare(arr1.length, arr2.length);

        if(answer == 0) {
            answer = Integer.compare(IntStream.of(arr1).sum(), IntStream.of(arr2).sum());
        }

        return answer;
    }
}
