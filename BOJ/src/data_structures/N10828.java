package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int size = 0;
		
		while (N-- > 0) {
			String s = br.readLine();
			
			if (s.equals("pop")) {
				if (size == 0) sb.append("-1").append('\n');
				else {
					sb.append(stack[size - 1]).append('\n');
					size--;
				}
			}
			
			else if (s.equals("size")) {
				sb.append(size).append('\n');
			}
			
			else if (s.equals("empty")) {
				if (size == 0) sb.append('1').append('\n');
				else sb.append('0').append('\n');
			}
			
			else if (s.equals("top")) {
				if (size == 0) sb.append("-1").append('\n');
				else sb.append(stack[size - 1]).append('\n');
			}
			
			else {
				stack[size] = Integer.parseInt(s.substring(5));
				size++;
			}
			
		}
		
		System.out.println(sb);
	}

}
