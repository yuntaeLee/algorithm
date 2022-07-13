package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class N15686 {
	
	static class Node {
		int x;
		int y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int ans = Integer.MAX_VALUE;
	static int N, M;
	
	static int map[][];
	
	static ArrayList<Node> chicken = new ArrayList<>();
	static ArrayList<Node> house = new ArrayList<>();
	
	static Stack<Node> select = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) house.add(new Node(i, j));
				else if (map[i][j] == 2) chicken.add(new Node(i, j));
			}
		}
		
		backTracking(0, 0);
		System.out.println(ans);
	}
	
	static void backTracking(int start, int depth) {
		
		if (depth == M) {
			int sum = 0;
			
			for (int i = 0; i < house.size(); i++) {
				int x1 = house.get(i).x;
				int y1 = house.get(i).y;
				int min = Integer.MAX_VALUE;
				
				for (Node n : select) {
					int x2 = n.x;
					int y2 = n.y;
					min = Math.min(min, getDistance(x1, y1, x2, y2));
				}
				
				sum += min;
			}
			
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			select.push(new Node(chicken.get(i).x, chicken.get(i).y));
			backTracking(i + 1, depth + 1);
			select.pop();
		}
	}
	
	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}
