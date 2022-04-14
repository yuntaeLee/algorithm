package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int count = 1;
		boolean flag = false;
		
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < i; j++) {
				if (count >= start) sum += i;
				
				if (count == end) {
					flag = true;
					break;
				}

				count++;
			}
			
			if (flag) break;
		}
		
		System.out.println(sum);
	}
}
