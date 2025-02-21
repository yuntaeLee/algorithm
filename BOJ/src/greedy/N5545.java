package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N5545 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int toppingCount = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int doughPrice = Integer.parseInt(st.nextToken());
        int toppingPrice = Integer.parseInt(st.nextToken());
        int doughCalories = Integer.parseInt(br.readLine());

        int[] caloriesOfToppings = new int[toppingCount];
        for (int i = 0; i < toppingCount; i++) {
            caloriesOfToppings[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(caloriesOfToppings);

        int totalCalories = doughCalories;
        int totalPrice = doughPrice;
        int answer = totalCalories / totalPrice;

        for (int i = 0; i < toppingCount; i++) {
            totalCalories += caloriesOfToppings[toppingCount - i - 1];
            totalPrice += toppingPrice;

            int cur = totalCalories / totalPrice;
            if (answer <= cur) {
                answer = cur;
                continue;
            }

            break;
        }

        System.out.println(answer);
    }
}
