package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17266 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] lamps = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			lamps[i] = Integer.parseInt(st.nextToken()); 
		}
		
		System.out.println(binarySearch(lamps, N));
	}
	
	static int binarySearch(int[] lamps, int n) {
		int left = 0;
		int right = n;
		int mid = 0;
		
		while (left < right) {
			mid = (left + right) / 2;
			
			if (isLightCovered(lamps, mid, n)) right = mid;
			else left = mid + 1;
		}
		
		return left;
	}
	
	static boolean isLightCovered(int[] lamp, int height, int n) {
		int start = 0;
		
		for (int i = 0; i < lamp.length; i++) {
			int left = lamp[i] - height;
			int right = lamp[i] + height;
			
			if (start < left) return false;
			else start = right;
		}
		
		if (n - start > 0) return false;
		
		return true;
	}
}
