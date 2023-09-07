package level1;

public class DartGame {

    public static void main(String[] args) {
        String dartResult = "1D#2S*3S";

        int actual = solution(dartResult);

        int expected = 5;
        System.out.println(actual == expected);
    }
    
    static int solution(String dartResult) {
        int[] dart = new int[3];
        int idx = 0;
        int number = 0;
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (isNumber(c)) {
                number = getNumber(dartResult.substring(i, i + 2));
                if (number == 10) {
                    i++;
                }
            } else if (isSign(c)) {
                dart[idx++] = (int) Math.pow(number, parseExponent(c));
                number = 0;
            } else {
                calculatePrize(dart, idx, c);
            }
        }
        
        return dart[0] + dart[1] + dart[2];
    }
    
    static void calculatePrize(int[] dart, int order, char type) {
        if (type == '*') {
            dart[order - 1] *= 2;
            
            if (order - 2 >= 0) {
                dart[order - 2] *= 2;
            }
            return;
        }
        
        dart[order - 1] *= -1;
    }
    
    static int parseExponent(char sign) {
        if (sign == 'S') return 1;
        if (sign == 'D') return 2;
        return 3;
    }
    
    static boolean isSign(char sign) {
        return sign == 'S' || sign == 'D' || sign == 'T';
    }
    
    static int getNumber(String s) {
        if (isNumber(s.charAt(1))) {
            return 10;
        }
        
        return s.charAt(0) - '0';
    }
    
    static boolean isNumber(char n) {
        return Character.isDigit(n);
    }
}
