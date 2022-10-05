class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        return climb(n, cost, dp);
    }
    public int climb(int n, int[] cost, int[] dp)
    {
        if(n == 0 || n == 1) return 0;
        
        if(dp[n] != 0) return dp[n];
        
        int one_step = cost[n-1] + climb(n-1, cost, dp);
        int two_step = cost[n-2] + climb(n-2, cost, dp);
        
        return dp[n] = Math.min(one_step, two_step);
    }
}