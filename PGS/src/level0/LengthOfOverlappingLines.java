package level0;

public class LengthOfOverlappingLines {

	public static void main(String[] args) {
		int[][] lines = {{-3, -1}, {-2, 1}, {0, 2}}; 
		System.out.println(solution(lines));
	}
	
	static int solution(int[][] lines) {
        int[] arr = new int[201];
        int answer = 0;
        
        for (int[] line : lines) {
            int s = line[0] + 100;
            int e = line[1] + 100;
            
            while (s < e) {
                if (++arr[s++] == 2) answer++;
            }
        }
        
        return answer;
    }

}
