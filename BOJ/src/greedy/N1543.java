package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1543 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String doc = br.readLine();
		String str = br.readLine();
		
		int count = 0;
		int idx = 0;
		
		for (int i = idx; i <= doc.length() - str.length(); i++) {
			boolean flag = true;
			
			for (int j = 0; j < str.length(); j++) {
				
				if (doc.charAt(i + j) != str.charAt(j)) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				count++;
				idx += str.length();
				i = idx - 1;
			}
			
			else {
				idx++;
			}
		}
		
		System.out.println(count);
	}

}
