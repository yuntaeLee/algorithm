package level2;

public class JumpAndTeleport {

    public static void main(String[] args) {
        int input = 5000;
        int result = 5;
		
        System.out.println(solution(input) == result);
    }
	
    static int solution(int n) {
        int ans = 0;
        
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            
            n--;
            ans++;
        }
        
        return ans;
    }
}
