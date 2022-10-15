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
}