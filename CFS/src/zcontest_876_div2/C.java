package zcontest_876_div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if (arr[n - 1] == 0) {
                sb.append("YES").append('\n');
                int i = n - 1;

                while (i >= 0) {
                    int j = i;
                    int f = 0;
                    int onee = 0;

                    while (j >= 0 && f <= arr[j]) {
                        f = arr[j];
                        onee += arr[j];
                        j--;
                    }

                    for (int k = j + 1; k < i; k++) {
                        sb.append("0 ");
                    }
                    sb.append(onee).append(" ");
                    i = j;
                }

                sb.append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
