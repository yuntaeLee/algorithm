package level3;

public class CollectStickers {

	public static void main(String[] args) {
		int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
		int result = 36;
		
		System.out.println(result == solution(sticker));
	}
	
	static int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1) return sticker[0];
        
        int answer = 0;
        int[] dp = new int[n];
        
        dp[0] = dp[1] = sticker[0];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        
        answer = Math.max(answer, dp[n - 2]);
        
        dp[0] = 0;
        dp[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        
        answer = Math.max(answer, dp[n - 1]);

        return answer;
    }
}
