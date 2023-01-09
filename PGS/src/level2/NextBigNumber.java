package level2;

public class NextBigNumber {

	public static void main(String[] args) {
		int input = 15;
		int result = 23;
		System.out.println(result == solution(input));
	}
	
    static int solution(int n) {
        int cnt = Integer.bitCount(n);
        while (cnt != Integer.bitCount(++n)) {}
        return n;
    }
}
