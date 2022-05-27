package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12368 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			
			sb.append('#').append(t).append(' ').append(time % 24).append('\n');
		}
		
		System.out.println(sb);
	}

}
