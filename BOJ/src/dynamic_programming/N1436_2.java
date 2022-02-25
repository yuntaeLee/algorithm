package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1436_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		
		System.out.println(recur(x, 0));
	}
	
	static int recur(int x, int count) {
		
		if (x < 2) return count;
		
		return Math.min(recur((x / 2),  count + 1 + (x % 2)), recur(x / 3, count + 1 + (x % 3)));
	}

}
