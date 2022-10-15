class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][4];
        //Initialization
        dp[0][0] = Math.min(costs[0][1], costs[0][2]);
        dp[0][1] = Math.min(costs[0][0], costs[0][2]);
        dp[0][2] = Math.min(costs[0][0], costs[0][1]);
        dp[0][3] = Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        
        for(int house=1; house<n; house++)
        {
            for(int last=0; last<4; last++)
            {
                dp[house][last] = Integer.MAX_VALUE;
                for(int color=0; color<3; color++)
                {
                    if(color != last)
                    {
                        int cost = costs[house][color] + dp[house-1][color];
                        dp[house][last] = Math.min(dp[house][last], cost);
                    }
                }
            }
        }
        
        return dp[n-1][3];
    }
    public int min(int n, int last, int[][] costs, int[][] memo)
    {
        if(n == 0)
        {
            int mini = Integer.MAX_VALUE;
            for(int i=0; i<3; i++)
            {
                if(i!=last) mini = Math.min(mini, costs[0][i]);
            }
            return mini;
        }
        
        if(memo[n][last] != 0) return memo[n][last];
        
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<3; i++)
        {
            if(i == last) continue;
            
            int cost = costs[n][i] + min(n-1, i, costs, memo);
            mini = Math.min(mini, cost);
        }
        
        return memo[n][last] = mini;
    }
}