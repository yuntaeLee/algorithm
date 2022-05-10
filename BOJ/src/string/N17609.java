package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N17609 {
	
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr = br.readLine().toCharArray();
			
			if (isPalindrome(0, arr.length - 1)) sb.append("0").append('\n');
			else if (isPseudoPalindrome(0, arr.length - 1)) sb.append("1").append('\n');
			else sb.append("2").append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean isPalindrome(int left, int right) {
		while (left <= right) {
			if (arr[left] != arr[right]) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	static boolean isPseudoPalindrome(int left, int right) {
		while (left < right) {
			
			if (arr[left] != arr[right]) {
				boolean a = isPalindrome(left + 1, right);
				boolean b = isPalindrome(left, right - 1);
				
				if (!a && !b) return false;
				else return true;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
}
