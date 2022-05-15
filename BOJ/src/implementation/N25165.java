package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N25165 {
	
	static int N, M;
	static int ac;
	static int D;
	static int sr, sc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ac = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		
		System.out.println(solution());
	}
	
	static String solution() {
		if (sr == N) {	
			if (D == 0 && N % 2 == 1) return "YES!";
			else if (D == 1 && N % 2 == 0) return "YES!";
		}
		
		return "NO...";
	}
}