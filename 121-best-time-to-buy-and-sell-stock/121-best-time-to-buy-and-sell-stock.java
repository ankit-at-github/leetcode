class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int mini = prices[0];
        for(int i=0; i<prices.length; i++)
        {
            profit = Math.max(profit, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }
}