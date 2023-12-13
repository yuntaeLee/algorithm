package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N19939 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = K - 1;

        // 1 2 3 4 5 6 7 8 9
        // 1 3 6 10 15 21 28 36 45
        if (N < K) {
            System.out.println(-1);
            return;
        }

        if (N % K != 0) {
            
        }
    }

    static int sigma(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }
}
