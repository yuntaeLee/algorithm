package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class N1141 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (s1, s2) -> s2.length() - s1.length());

        Set<String> set = new HashSet<>();
        set.add(arr[0]);
        for (int i = 1; i < N; i++) {
            String s1 = arr[i];

            boolean flag = true;
            for (String s2 : set) {
                if (s2.indexOf(s1) == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                set.add(s1);
            }
        }

        System.out.println(set.size());
    }
}
