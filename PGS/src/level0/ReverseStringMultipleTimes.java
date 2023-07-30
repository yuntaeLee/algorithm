package level0;

public class ReverseStringMultipleTimes {
    
    public static void main(String[] args) {
        String my_string = "rermgorpsam";
        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};

        String actual = solution(my_string, queries);

        String expected = "programmers";
        System.out.println(actual.equals(expected));
    }

    static String solution(String my_string, int[][] queries) {
        for (int[] q : queries) {
            my_string = reverse(my_string, q[0], q[1]);
        }
        return my_string;
    }
    
    static String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder target = new StringBuilder(s.substring(start, end + 1));
        return sb.replace(start, end + 1, target.reverse().toString()).toString();
    }
}
