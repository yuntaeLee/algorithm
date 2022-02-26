package number_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1978 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		boolean[] decimal = new boolean[1001];
		decimal[0] = decimal[1] = true;
		
		for (int i = 2; i < Math.sqrt(decimal.length); i++) {
			for (int j = i * i; j <= 1000; j = j + i) {
				if (!decimal[j])
					 decimal[j] = true;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (!decimal[Integer.parseInt(st.nextToken())])
				 count++;
		}
		
		System.out.println(count);
	}

}
