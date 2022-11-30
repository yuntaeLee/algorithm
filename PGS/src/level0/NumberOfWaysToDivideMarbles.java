package level0;

public class NumberOfWaysToDivideMarbles {

	public static void main(String[] args) {
		System.out.println(solution(3, 2));
	}
	
    static int solution(int balls, int share) {
        return comb(balls, share);
    }
    
    static int comb(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        
        return comb(n - 1, r - 1) + comb(n - 1, r);
    }

}
