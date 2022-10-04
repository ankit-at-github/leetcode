class Solution {
    public int climbStairs(int n) {
        //you either take one step or two step
        //Recursion
        //only one step to reach the top so only one way.
        int[] dp = new int[n+1];
        return climb(n, dp);
    }
    public int climb(int n, int[] dp)
    {
        if(n<=1) return 1;
        
        if(dp[n] != 0) return dp[n];
        
        return dp[n] = climb(n-1, dp) + climb(n-2, dp);
    }
}