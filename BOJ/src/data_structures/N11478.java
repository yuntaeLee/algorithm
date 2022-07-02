package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class N11478 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				set.add(s.substring(i, j + 1));
			}
		}
		
		System.out.println(set.size());
	}

}
