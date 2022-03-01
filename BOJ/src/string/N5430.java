package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class N5430 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> deque;
		
		while (T-- > 0) {
			
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			deque = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine(), "[,]");
			
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(command, deque);
			
		}
		
		System.out.println(sb);
	}
	
	static void AC(String command, Deque<Integer> deque) {
		boolean isFront = true;
		
		for (char cmd : command.toCharArray()) {
			
			if (cmd == 'R') {
				isFront = !isFront;
				continue;
			}
			
			if (isFront) {
				
				if (deque.pollFirst() == null) {
					sb.append("error").append('\n');
					return;
				}
			}
			
			else {
				
				if (deque.pollLast() == null) {
					sb.append("error").append('\n');
					return;
				}
			}
		}
		
		printDeque(isFront, deque);
	}
	
	static void printDeque(boolean isFront, Deque<Integer> deque) {
		
		sb.append('[');
		
		if (deque.size() > 0) {
			
			// 정방향
			if (isFront) {
				sb.append(deque.pollFirst());
				
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			
			// 역방향
			else {
				sb.append(deque.pollLast());
				
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		
		sb.append(']').append('\n');
		
	}
	
}
