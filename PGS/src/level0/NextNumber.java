package level0;

public class NextNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 4, 8}));
	}
	
    static int solution(int[] common) {
        if (common[1] - common[0] == common[2] - common[1]) {
            return common[common.length - 1] + common[1] - common[0];
        }
        
        return common[common.length - 1] * (common[1] / common[0]);
    }
}
