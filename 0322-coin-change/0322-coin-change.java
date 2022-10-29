class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] memo = new int[n][amount+1];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<amount+1; j++) memo[i][j] = -1;
        }
        
        int ans = counts(n-1, coins, amount, memo);
        return ans >= Integer.MAX_VALUE-1 ? -1 : ans;
    }
    public int counts(int index, int[] coins, int amount, int[][] memo)
    {
        //base case
        if(index == 0)
        {
            if(amount % coins[0] == 0) return amount/coins[0];
            else return Integer.MAX_VALUE-1;
        }
        
        if(memo[index][amount] != -1) return memo[index][amount];
        
        int notTake = counts(index-1, coins, amount, memo);
        
        int take = Integer.MAX_VALUE;
        
        if(coins[index] <= amount) take = 1 + counts(index, coins, amount-coins[index], memo);
        
        return memo[index][amount] = Math.min(notTake, take);
    }
}