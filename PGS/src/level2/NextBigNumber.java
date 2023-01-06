package level2;

public class NextBigNumber {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}
	
    static int solution(int n) {
        int cnt = Integer.bitCount(n);
        while (cnt != Integer.bitCount(++n)) {}
        return n;
    }
}
