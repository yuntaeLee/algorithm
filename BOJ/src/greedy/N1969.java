package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1969 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int distance = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            int[] alphabet = new int[26];
            for (int j = 0; j < N; j++) {
                int a = arr[j].charAt(i) - 'A';
                alphabet[a]++;
            }

            int max = -1;
            int maxIdx = -1;
            for (int j = 0; j < 26; j++) {
                if (max < alphabet[j]) {
                    max = alphabet[j];
                    maxIdx = j;
                }
            }

            distance += N - max;
            answer.append((char) (65 + maxIdx));
        }

        answer.append('\n').append(distance);
        System.out.println(answer);
    }
}
