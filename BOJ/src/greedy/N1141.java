package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1141 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        int answer = 1;
        for (int i = 0; i < N - 1; i++) {
            if (!isPrefix(arr[i], arr[i + 1])) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean isPrefix(String prefix, String s) {
        return s.indexOf(prefix) == 0;
    }
}
