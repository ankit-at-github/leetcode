class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n][amount+1];
        
        for(int index=0; index<n; index++)
        {
            for(int money=0; money<amount+1; money++) memo[index][money] = -1;
        }
        
        return counts(n-1, coins, amount, memo);
    }
    public int counts(int index, int[] coins, int amount, int[][] memo)
    {   
        if(index == 0)
        {
            if(amount % coins[0] == 0) return 1;
            return 0;
        }
        
        if(memo[index][amount] != -1) return memo[index][amount];
        
        int notTake = counts(index-1, coins, amount, memo);
        
        int take = 0;
        if(coins[index] <= amount) take = counts(index, coins, amount-coins[index], memo);
        
        return memo[index][amount] = notTake+take;
    }
}