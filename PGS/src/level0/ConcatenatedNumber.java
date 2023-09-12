package level0;

public class ConcatenatedNumber {
    
    public static void main(String[] args) {
        int[] num_list = {3, 4, 5, 2, 1};

        int actual = solution(num_list);

        int expected = 393;
        System.out.println(actual == expected);
    }

    static int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for (int i = 0; i < num_list.length; i++) {
            int n = num_list[i];
            if (n % 2 == 0) {
                even.append(n);
                continue;
            }
            
            odd.append(n);
        }
        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }
}
