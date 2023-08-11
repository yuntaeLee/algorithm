package level2;

import java.util.Arrays;

public class StockPrice {
    
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        
        int[] actual = solution(prices);

        int[] expected = {4, 3, 1, 1, 0};
        System.out.println(Arrays.equals(actual, expected));
    }

    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}
