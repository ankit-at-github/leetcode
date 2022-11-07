class Solution {
    public int maxProfit(int[] prices) {
        //solve this question by DP, by take not take method.
        int totalProfit = 0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i-1] < prices[i])
            {
                totalProfit+=prices[i]-prices[i-1];
            }
        }
        return totalProfit;
    }
}