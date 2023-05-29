package level3;

public class Immigration {
    
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        long actual = solution(n, times);

        long expected = 28;
        System.out.println(actual == expected);
    }

    static long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
