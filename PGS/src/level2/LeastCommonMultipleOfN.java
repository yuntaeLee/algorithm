package level2;

public class LeastCommonMultipleOfN {
    
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};

        int actual = solution(arr);

        int expected = 168;
        System.out.println(actual == expected);
    }

    static int solution(int[] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}
