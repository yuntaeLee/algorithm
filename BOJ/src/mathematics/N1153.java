package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N1153 {
	
	static ArrayList<Integer> primes = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		aratos(N);
		
		if (N < 8) {
			System.out.println(-1);
			return;
		} 
		
		if (N % 2 == 0) {
			N -= 4;
			sb.append('2').append(' ').append('2').append(' ');
			goldbach(N);
		} else {
			N -= 5;
			sb.append('2').append(' ').append('3').append(' ');
			goldbach(N);
		}
		
		System.out.println(sb);
	}
	
	static void goldbach(int N) {
		for (int i = 0; i < primes.size(); i++) {
			for (int j = 0; j < primes.size(); j++) {
				int sum = primes.get(i) + primes.get(j);
				
				if (sum == N) {
					sb.append(primes.get(i)).append(' ').append(primes.get(j));
					return;
				} else if (sum > N) break;
			}
		}
	}
	
	static void aratos(int N) {
		boolean[] isPrime = new boolean[N + 1];
		isPrime[0] = isPrime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			
			if (!isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = true;
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {
			if (!isPrime[i]) primes.add(i);
		}
	}
}
