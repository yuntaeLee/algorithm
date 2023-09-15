package level0;

public class NumberControl1 {
    
    public static void main(String[] args) {
        int n = 0;
        String control = "wsdawsdassw";

        int actual = solution(n, control);

        int expected = -1;
        System.out.println(actual == expected);
    }

    static int solution(int n, String control) {
        for (int i = 0; i < control.length(); i++) {
            char command = control.charAt(i);
            n = f(n, command);
        }
        
        return n;
    }
    
    static int f(int n, char command) {
        if (command == 'w') return n + 1;
        if (command == 's') return n - 1;
        if (command == 'd') return n + 10;
        return n - 10;
    }
}
