package level1;

public class Cola {

	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int n = 20;
		
		int result = 19;
		System.out.println(result == solution(a, b, n));
	}
	
	static int solution(int a, int b, int n) {
		return (int) Math.floor(Math.max(n - b, 0) / (a - b)) * b;
	}
}
