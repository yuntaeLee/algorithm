package d800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DominoPiling {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int area = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		System.out.println(area / 2);
	}

}
