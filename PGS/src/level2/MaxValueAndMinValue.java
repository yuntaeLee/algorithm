package level2;

public class MaxValueAndMinValue {

	public static void main(String[] args) {
		String ans = solution("-1 -2 -3 -4");
		System.out.println(ans);
	}
	
	static String solution(String s) {
		String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            int n = Integer.parseInt(arr[i]);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        return new StringBuilder().append(min).append(' ').append(max).toString();
	}
}
