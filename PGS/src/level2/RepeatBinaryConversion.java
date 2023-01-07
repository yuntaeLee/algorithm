package level2;

public class RepeatBinaryConversion {

	public static void main(String[] args) {
		int cycle = 3;
		int zero = 8;
		
		String input = "110010101001";
		int[] result = solution(input);
		
		System.out.println(cycle == result[0] && zero == result[1]);
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
