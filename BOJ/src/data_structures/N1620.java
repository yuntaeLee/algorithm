package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		String[] names = new String[N + 1];
		
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			
			map.put(name, i);
			names[i] = name;
		}
		
		for (int i = 0; i < M; i++) {
			String findValue = br.readLine();
			
			if (map.containsKey(findValue)) {
				sb.append(map.get(findValue)).append('\n');
			}
			else {
				sb.append(names[Integer.parseInt(findValue)]).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
//	static boolean isTransforStringToInteger(String s) {
//		
//		try {
//			Integer.parseInt(s);
//			return true;
//		}
//		catch (NumberFormatException e) {
//			return false;
//		}
//	}
}
