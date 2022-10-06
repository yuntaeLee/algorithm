package level0;

public class MakeBFromA {

	public static void main(String[] args) {
		System.out.println(solution("olleh", "hello"));
	}
	
	static int solution(String before, String after) {
		int[] ascii = new int[26];
        
        for (int i = 0; i < before.length(); i++) {
            ascii[before.charAt(i) - 'a']++;
            ascii[after.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (ascii[i] % 2 == 1) return 0;
        }
        
        return 1;
	}

}
