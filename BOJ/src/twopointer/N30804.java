package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N30804 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> fruitsCount = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            fruitsCount.put(fruits[right], fruitsCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitsCount.size() > 2) {
                fruitsCount.put(fruits[left], fruitsCount.get(fruits[left]) - 1);

                if (fruitsCount.get(fruits[left]) == 0) {
                    fruitsCount.remove(fruits[left]);
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}
