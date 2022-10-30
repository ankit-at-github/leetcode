class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int index=0; index<n; index++) dp[index][0] = 1;
        
        for(int money=0; money<amount+1; money++)
        {
            if(money % coins[0] == 0) dp[0][money] = 1;
            else dp[0][money] = 0;
        }
        
        for(int index=1; index<n; index++)
        {
            for(int money=0; money<amount+1; money++)
            {
                int notTake = dp[index-1][money];
                
                int take = 0;
                if(coins[index] <= money) take = dp[index][money-coins[index]];
                
                dp[index][money] = notTake+take;
            }
        }
        return dp[n-1][amount];
    }
}