package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Stack<Character> op = new Stack<>();
		
		for (Character c : str.toCharArray()) {
			if ('A' <= c && c <= 'Z') sb.append(c);
			else if (c == '(') op.push(c);
			else if (c == ')') {
				while (!op.isEmpty()) {
					if (op.peek() == '(') {
						op.pop();
						break;
					}
					sb.append(op.pop());
				}
			}
			else {
				while (!op.isEmpty() && priority(op.peek()) >= priority(c)) {
					sb.append(op.pop());
				}
				op.push(c);
			}
		}
		
		while (!op.isEmpty()) sb.append(op.pop());
		
		System.out.println(sb);
	}
	
	static int priority(char op) {
		if (op == '*' || op == '/') return 2;
		else if (op == '+' || op == '-') return 1;
		else return 0;
	}

}
