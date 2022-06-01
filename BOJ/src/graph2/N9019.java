package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9019 {
	
	static char[] comm = {'D', 'S', 'L', 'R'};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			bfs(A, B);
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int val, int target) {
		boolean[] visited = new boolean[10000];
		String[] commands = new String[10000];
		Queue<Integer> q = new LinkedList<>();
		
		visited[val] = true;
		Arrays.fill(commands, "");
		q.offer(val);

		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (char c : comm) {
				int next = f(cur, c);
				
				if (!visited[next]) {
					visited[next] = true;
					commands[next] = commands[cur] + c;
					q.offer(next);
				}
				
				if (next == target) {
					sb.append(commands[target]).append('\n');
					return;
				}
			}
		}
	}
	
	static int f(int val, char s) {
		if (s == 'D') return (2 * val) % 10000;
		else if (s == 'S') return val == 0 ? 9999 : val - 1;
		else if (s == 'L') return (val % 1000) * 10 + val / 1000;
		return (val % 10) * 1000 + val / 10;
	}
	
}
