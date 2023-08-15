package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tuple {
    
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        int[] actual = solution(s);

        int[] expected = {2, 1, 3, 4};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(String s) {
        String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
        int[] answer = new int[arr.length];
        Set<Integer> set = new HashSet<>();
        
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        
        int idx = 0;
        for (String str : arr) {
            for (String st : str.split(",")) {
                int n = Integer.parseInt(st);
                if (set.add(n)) {
                    answer[idx++] = n;
                }
            }
        }
        
        return answer;
    }
}
