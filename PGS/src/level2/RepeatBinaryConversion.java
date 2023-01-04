package level2;

import java.util.Arrays;

public class RepeatBinaryConversion {

	public static void main(String[] args) {
		System.out.println(Arrays.toString((solution("110010101001"))));
	}

    static int[] solution(String s) {
        int zero = 0;
        int cnt = 0;
        while (s.length() > 1) {
            String removeZero = s.replace("0", "");
            zero += s.length() - removeZero.length();
            cnt++;
            
            s = Integer.toBinaryString(removeZero.length());
        }
        
        return new int[] {cnt, zero};
    }
}
