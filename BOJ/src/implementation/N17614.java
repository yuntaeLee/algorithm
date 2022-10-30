package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N17614 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
        int number = Integer.parseInt(br.readLine());
        int answer = 0;
	        
        for (int i = 1; i <= number; i++) {
            int num = i;

            while (num > 0) {
                int n = num % 10;
                if (n == 3 || n == 6 || n == 9) {
                    answer++;
                }

                num /= 10;
            }
        }
        
        System.out.println(answer);
	}

}
