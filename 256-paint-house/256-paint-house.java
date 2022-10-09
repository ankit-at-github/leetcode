class Solution {
    public int minCost(int[][] costs) {
        //we need to consider all ways
        int n = costs.length;
        int[][] dp = new int[n][4];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<=3; j++) dp[i][j] = -1;
        }
        return min(dp, n-1, 3, costs);
    }
    public int min(int[][] dp, int n, int last, int[][] costs)
    {
        if(n == 0)
        {
            int mini = Integer.MAX_VALUE;
            for(int i=0; i<costs[0].length; i++)
            {
                if(i!=last) mini = Math.min(mini, costs[0][i]);
            }
            return mini;
        }
        
        if(dp[n][last] != -1) return dp[n][last];
        
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<3; i++)
        {
            if(i == last) continue;
            
            int cost = costs[n][i] + min(dp, n-1, i, costs);
            
            mini = Math.min(mini, cost);
        }
        
        return dp[n][last] = mini;
    }
}