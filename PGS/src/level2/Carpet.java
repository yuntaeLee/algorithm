package level2;

public class Carpet {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		
		int[] expect = {4, 3};
		int[] result = solution(brown, yellow);
		System.out.println((expect[0] == result[0]) && (expect[1] == result[1]));
	}
	
	static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int i = 3; i < sum; i++) {
            int j = sum / i;
            
            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);
                
                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}
