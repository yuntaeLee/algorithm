package level0;

public class ShareAPizza2 {

	public static void main(String[] args) {
		
	}
	
	public int solution(int n) {
        return lcm(n, 6) / 6;
    }
    
    static int gcd(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        
        return gcd(n2, n1 % n2);
    }
    
    static int lcm(int n1, int n2) {
        return n1 * n2 / gcd(n1, n2);
    }

}
