package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N18110 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        int removedLength = (int) Math.round(n * 0.15);
        for (int i = removedLength; i < n - removedLength; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round((double) sum / (n - removedLength * 2)));
    }
}
