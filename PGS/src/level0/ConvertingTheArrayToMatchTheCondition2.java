package level0;

public class ConvertingTheArrayToMatchTheCondition2 {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 100, 99, 98};

        int actual = solution(arr);

        int expected = 5;
        System.out.println(actual == expected);
    }

    static int solution(int[] arr) {
        int answer = 0;
        while (operate(arr)) {
            answer++;
        }
        
        return answer > 0 ? answer + 1 : answer;
    }
    
    static boolean operate(int[] arr) {
        boolean isChange = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] >= 50) {
                arr[i] /= 2;
                isChange = true;
            } else if (arr[i] % 2 == 1 && arr[i] < 50) {
                arr[i] *= 2 + 1;
                isChange = true;
            }
        }
        
        return isChange;
    }
}
