package level1;

public class Paint {

    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};

        int actual = solution(n, m, section);

        int expected = 2;
        System.out.println(actual == expected);
    }
    
    static int solution(int n, int m, int[] section) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < section.length; i++) {
            if (sum <= section[i]) {
                sum = section[i] + m;
                answer++;
            }
        }
        
        return answer;
    }
}
