package dynamic_programming2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N12015 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(LIS(N, arr));
    }

    static int LIS(int N, int[] arr) {
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        for (int i = 1; i < N; i++) {
            int v = arr[i];

            if (lis.get(lis.size() - 1) < v) {
                lis.add(v);
                continue;
            }

            int left = 0;
            int right = lis.size();

            while (left < right) {
                int mid = (left + right) / 2;

                if (lis.get(mid) < v) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            lis.set(left, v);
        }

        return lis.size();
    }
}
