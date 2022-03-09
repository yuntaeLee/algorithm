package level1;

import java.util.Arrays;

public class Knumber {
	
	public int[] solution(int[] array, int[][] commands) {
		
        int[] answer = new int[commands.length];

        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] arr = new int[j - i + 1];
            
            for (int b = i - 1, idx = 0; b < j; b++, idx++) {
                arr[idx] = array[b];
            }
            
            Arrays.sort(arr);
            answer[a] = arr[k - 1];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
	}

}
