package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int newN = N;
		int cycle = 0;
		
		while (true) {
			int left = newN / 10;
			int right = newN % 10;
			newN = (right * 10) + (left + right) % 10;
			cycle++;
			
			if (N == newN) break;
		}
		
		System.out.println(cycle);
	}

}
