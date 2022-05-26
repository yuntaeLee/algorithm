package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class N13229 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("SUN", 7);
		map.put("MON", 6);
		map.put("TUE", 5);
		map.put("WED", 4);
		map.put("THU", 3);
		map.put("FRI", 2);
		map.put("SAT", 1);
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			String s = br.readLine();
			sb.append('#').append(i).append(' ').append(map.get(s)).append('\n');
		}
		
		System.out.println(sb);
	}
}
