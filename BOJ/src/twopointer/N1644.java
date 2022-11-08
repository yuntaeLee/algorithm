package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N1644 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrime = makePrimeArray(N);
		List<Integer> primes = new ArrayList<>();
		
		for (int i = 2; i <= N; i++) {
			if (!isPrime[i]) {
				primes.add(i);
			}
		}
		
		int sum = 0;
		int idx = 0;
		int cnt = 0;
		for (int i = 0; i < primes.size(); i++) {
			sum += primes.get(i);
			
			while (sum > N) {
				sum -= primes.get(idx++);
			}
			
			if (sum == N) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static boolean[] makePrimeArray(int N) {
		boolean[] prime = new boolean[N + 1];
		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = true;
				}
			}
		}
		
		return prime;
	}
}
