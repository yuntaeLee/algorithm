package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class N2407 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger nn = BigInteger.ONE;
		BigInteger mm = BigInteger.ONE;
		
		for (int i = 1; i <= m; i++) {
			nn = nn.multiply(BigInteger.valueOf(n--));
			mm = mm.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(nn.divide(mm));
	}
}
