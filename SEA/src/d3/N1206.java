package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1206 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; t <= 1; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for (int i = 2; i < N - 2; i++) {
                int left = Math.max(arr[i - 2], arr[i - 1]);
                int right = Math.max(arr[i + 1], arr[i + 2]);
                int max = Math.max(left, right);

                if (arr[i] - max > 0) {
                    answer += arr[i] - max;
                }
            }

            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}
