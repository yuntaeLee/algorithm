package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1052 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(getCountOfBuyingBottle(N, K));
    }

    static int getCountOfBuyingBottle(int n, int k) {
        if (n <= k) return 0;

        for (int i = 0; i < k - 1; i++) {

            int exponent = 0;
            while (Math.pow(2, exponent) < n) {
               exponent++;
            }
            n -= Math.pow(2, exponent - 1);

            if (n == 0) return 0;
        }

        int exponent = 0;
        while (Math.pow(2, exponent) < n) {
            exponent++;
        }

        return (int) Math.pow(2, exponent) - n;
    }
}
