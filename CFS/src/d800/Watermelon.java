package d800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Watermelon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int w = Integer.parseInt(br.readLine());
        
        if (w % 2 == 0) {
        	if (w == 2) System.out.println("NO");
        	else System.out.println("YES");
        }
        
        else System.out.println("NO");
	}
}
