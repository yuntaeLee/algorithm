package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N4386 {
	
	static class Point {
		int num;
		double x;
		double y;
		
		Point(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		double weight;
		
		Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		
		@Override
		public int compareTo(Edge e) {
			if (weight < e.weight) {
				return -1;
			}
			
			return 1;
		}
	}
	
	static double ans;
	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		parent = new int[N];
		Point[] points = new Point[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			points[i] = new Point(i, x, y);
			
			parent[i] = i;
		}
		
		edgeList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double weight = getDistance(points[i], points[j]);
				
				edgeList.add(new Edge(points[i].num, points[j].num, weight));
			}
		}
		
		Collections.sort(edgeList);
		
		// Kruskal
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			if (find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		System.out.println(ans);
	}
	
	static double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x > y) parent[y] = x;
		else parent[x] = y;
	}
}
