class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] memo = new int[n][4];
        return min(n-1, 3, costs, memo);
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