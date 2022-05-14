class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxi = prices[prices.length-1];
        for(int i=prices.length-1; i>=0; i--)
        {
            profit = Math.max(profit, maxi - prices[i]);
            maxi = Math.max(maxi, prices[i]);
        }
        return profit;
    }
}