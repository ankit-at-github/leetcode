class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        return solve(cost, memo, n);
    }
    public int solve(int[] cost, int[] memo, int index)
    {   
        //starts from that point, no cost
        if(index == 0 || index == 1) return 0;
        
        if(memo[index] != 0) return memo[index];
        
        int one_step = cost[index-1] + solve(cost, memo, index-1);
        int two_step = cost[index-2] + solve(cost, memo, index-2);
        
        return memo[index] = Math.min(one_step, two_step);
    }
}