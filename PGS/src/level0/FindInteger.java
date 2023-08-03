package level0;

public class FindInteger {
    
    public static void main(String[] args) {
        int[] num_list = {1, 2, 3, 4, 5};
        int n = 3;

        int actual = solution(num_list, n);

        int excepted = 1;
        System.out.println(actual == excepted);
    }

    static int solution(int[] num_list, int n) {
        for (int num : num_list) {
            if (num == n) {
                return 1;
            }
        }
        return 0;
    }
}
