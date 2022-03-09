package level1;

import java.util.ArrayList;
import java.util.List;

public class HateTheSameNumber {
	
    public int[] solution(int []arr) {
    	
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) list.add(arr[i]);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    
	public static void main(String[] args) {
		
	}

}
