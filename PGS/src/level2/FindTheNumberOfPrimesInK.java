package level2;

public class FindTheNumberOfPrimesInK {
    
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;

        int actual = solution(n, k);

        int expected = 3;
        System.out.println(actual == expected);
    }

    static int solution(int n, int k) {
        String[] arr = Integer.toString(n, k).split("0");
        int answer = 0;
        
        for (String s : arr) {
            if (s.equals("")) continue;
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
