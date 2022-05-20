package medium;

public class N198 {

	public static void main(String[] args) {
		int ans = rob(new int[] {2,1,1,2});
		
		System.out.println(ans);
	}
	
    static int rob(int[] nums) {
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = 0;
        
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[1][i - 1] + nums[i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
        }
        
        return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
    }
    
    static int rob2(int[] nums) {
    	int rob1 = 0;
    	int rob2 = 0;
    	
    	for (int num : nums) {
    		int temp = Math.max(num + rob1, rob2);
    		rob1 = rob2;
    		rob2 = temp;
    	}
    	
    	return rob2;
    }

}
