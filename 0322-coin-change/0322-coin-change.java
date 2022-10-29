class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int money=0; money<amount+1; money++)
        {
            if(money % coins[0] == 0)
                dp[0][money] = money/coins[0];
            else dp[0][money] = Integer.MAX_VALUE-1;
        }
        
        for(int index=1; index<n; index++)
        {
            for(int money=0; money<amount+1; money++)
            {
                int notTake = dp[index-1][money];
                
                int take = Integer.MAX_VALUE;
                if(coins[index] <= money) take = 1 + dp[index][money-coins[index]];
                
                dp[index][money] = Math.min(notTake, take);
            }
        }
        return dp[n-1][amount] >= Integer.MAX_VALUE-1 ? -1 : dp[n-1][amount];
    }
}