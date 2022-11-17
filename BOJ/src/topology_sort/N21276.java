package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class N21276 {
	
	static int N;
	static int[] inDegree;
	static String[] people;
	
	static List<Integer> roots = new ArrayList<>();
	static List<List<Integer>> child = new ArrayList<>();
	static List<List<Integer>> graph = new ArrayList<>();
	static Map<String, Integer> indexOfPeople = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		inDegree = new int[N];
		people = new String[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = st.nextToken();
		}
		
		Arrays.sort(people);
		
		init();
		
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int childIdx = indexOfPeople.get(st.nextToken());
			int parentIdx = indexOfPeople.get(st.nextToken());
			
			graph.get(parentIdx).add(childIdx);
			inDegree[childIdx]++;
		}
		
		topologySort();
		
		print();
	}
	
	static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
				roots.add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph.get(cur)) {
				if (--inDegree[next] == 0) {
					child.get(cur).add(next);
					q.offer(next);
				}
			}
		}
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(roots.size()).append('\n');
		for (int index : roots) {
			sb.append(people[index]).append(' ');
		}
		
		sb.append('\n');
		
		for (int i = 0; i < N; i++) {
			sb.append(people[i]).append(' ').append(child.get(i).size()).append(' ');
			Collections.sort(child.get(i));
			
			for (int index : child.get(i)) {
				sb.append(people[index]).append(' ');
			}
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void init() {
		for (int i = 0; i < N; i++) {
			indexOfPeople.put(people[i], i);
			graph.add(new ArrayList<>());
			child.add(new ArrayList<>());
		}
	}
}