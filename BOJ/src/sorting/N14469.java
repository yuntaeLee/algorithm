package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14469 {

    static class Cow implements Comparable<Cow> {
        int arrivalTime = 0;
        int inspectionTime = 0;

        Cow(int arrivalTime, int inspectionTime) {
            this.arrivalTime = arrivalTime;
            this.inspectionTime = inspectionTime;
        }

        @Override
        public int compareTo(Cow o) {
            if (this.arrivalTime == o.arrivalTime) {
                return this.inspectionTime - o.inspectionTime;
            }

            return this.arrivalTime - o.arrivalTime;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int arrivalTime = Integer.parseInt(st.nextToken());
            int inspectionTime = Integer.parseInt(st.nextToken());

            cows[i] = new Cow(arrivalTime, inspectionTime);
        }

        Arrays.sort(cows);

        for (Cow cow : cows) {
            answer = Math.max(answer, cow.arrivalTime);
            answer += cow.inspectionTime;
        }

        System.out.println(answer);
    }
}
