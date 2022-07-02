package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		while (a-- > 0) set.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		while (b-- > 0) {
			int n = Integer.parseInt(st.nextToken());
			
			if (set.contains(n)) set.remove(n);
			else set.add(n);
		}
		
		System.out.println(set.size());
	}
}
