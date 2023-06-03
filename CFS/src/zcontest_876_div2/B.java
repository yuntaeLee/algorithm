package zcontest_876_div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if (!map.containsKey(a)) {
                    map.put(a, new ArrayList<>());
                }

                map.get(a).add(b);
            }

            for (int key : map.keySet()) {
                Collections.sort(map.get(key), Collections.reverseOrder());
            }

            long answer = 0;
            for (int i = 1; i <= n; i++) {
                if (map.get(i) == null) continue;
                for (int j = 0; j < i && j < map.get(i).size(); j++) {
                    answer += map.get(i).get(j);
                }
            }

            sb.append(answer).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}
