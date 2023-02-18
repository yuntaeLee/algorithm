package level2;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int result = 3;
		
        System.out.println(result == solution(citations));
    }
	
    static int solution(int[] citations) {
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        
        return 0;
    }
}
