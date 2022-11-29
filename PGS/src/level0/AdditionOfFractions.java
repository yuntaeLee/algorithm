package level0;

public class AdditionOfFractions {

	public static void main(String[] args) {
		int[] arr = solution(9, 2, 1, 3);
		System.out.printf("%d\n---\n%d", arr[0], arr[1]);
	}
	
    static int[] solution(int denum1, int num1, int denum2, int num2) {
        int denum = denum1 * num2 + denum2 * num1;
        int gcd = gcd(denum, num1 * num2);
        return new int[] {denum / gcd, num1 * num2 / gcd};
    }
    
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
