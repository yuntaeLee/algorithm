package zcontest_876_div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int answer = n;
            for (int i = 1; i <= n; i++) {
                int l = (i + k - 2) / k;
                int r = (n - i + k - 1) / k;
                answer = Math.min(answer, l + r);
            }

            sb.append(answer + 1).append('\n');
        }

        System.out.println(sb.toString());
    }
}
