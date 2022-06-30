package topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1516 {
	
	static class Building implements Comparable<Building> {
		int num;
		int time;
		
		Building(int num, int time) {
			this.num = num;
			this.time = time;
		}
		
		@Override
		public int compareTo(Building b) {
			return time - b.time;
		}
	}
	
	static int N;
	
	static int[] inDegree;
	static Building[] buildings;
	
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		inDegree = new int[N + 1];
		buildings = new Building[N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			buildings[i] = new Building(i, time);
			
			while (true) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num == -1) break;
				
				list.get(num).add(i);
				inDegree[i]++;
			}
		}
		
		topologySort();
		
		for (int i = 1; i <= N; i++) {
			sb.append(buildings[i].time).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void topologySort() {
		PriorityQueue<Building> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				pq.offer(buildings[i]);
			}
		}
		
		while (!pq.isEmpty()) {
			int cur = pq.poll().num;
			
			for (int next : list.get(cur)) {
				
				if (--inDegree[next] == 0) {
					buildings[next].time += buildings[cur].time;
					pq.offer(new Building(next, buildings[next].time));
				}
			}
		}
	}

}
