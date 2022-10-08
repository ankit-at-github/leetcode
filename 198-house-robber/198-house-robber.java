class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxProfit(n-1, nums, dp);
    }
    public int maxProfit(int index, int[] nums, int[] dp)
    {
        if(index == 0) return nums[index];
        
        if(index < 0) return 0;
        
        if(dp[index] != -1) return dp[index];
        
        int pick = nums[index] + maxProfit(index-2, nums, dp);
        
        int notpick = maxProfit(index-1, nums, dp);
        
        return dp[index] = Math.max(pick, notpick);
    }
}