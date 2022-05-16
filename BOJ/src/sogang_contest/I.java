package sogang_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		for (int i = 0; i < N - 4; i++) {
			if (isWinning(arr, i)) {
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}
	
	static boolean isWinning(char[] arr, int idx) {
		int ans = 1;
		
		for (int i = idx; i < idx + 4; i++) {
			if (arr[i + 1] == arr[i] + 1 || arr[i + 1] == arr[i] - 1) {
				ans++;
			}
		}
		if (ans == 5) return true;
		else return false;
	}
}
