package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N5635 {
	
	static class Birthday implements Comparable<Birthday>{
		String name;
		int day;
		int month;
		int year;
		
		Birthday (String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}

		@Override
		public int compareTo(Birthday o) {
			if (year == o.year) {
				if (month == o.month) {
					
					return o.day - day;
				}
				return o.month - month;
			}
			return o.year - year;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Birthday[] arr = new Birthday[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			arr[i] = new Birthday(name, day, month, year);
		}
		
		Arrays.sort(arr);
		
		sb.append(arr[0].name).append('\n');
		sb.append(arr[n - 1].name);
		
		System.out.println(sb);
	}

}
