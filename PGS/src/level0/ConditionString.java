package level0;

public class ConditionString {
    
    public static void main(String[] args) {
        String ineq = "<";	
        String eq = "=";
        int n = 20;
        int m = 50;

        int actual = solution(ineq, eq, n, m);

        int expected = 1;
        System.out.println(actual == expected);
    }

    static int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals("<")) {
            if (eq.equals("=")) {
                return n <= m ? 1 : 0;
            }
            
            return n < m ? 1 : 0;
        }
        
        if (eq.equals("=")) {
            return n >= m ? 1 : 0;
        }
        
        return n > m ? 1 : 0;
    }
}
