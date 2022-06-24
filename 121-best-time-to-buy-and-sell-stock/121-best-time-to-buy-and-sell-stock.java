class Solution {
    public int maxProfit(int[] prices) {
        int j = 0, mini = prices[0], maxi = 0;
        while(j < prices.length)
        {
            if(prices[j] < mini) mini = prices[j];
            maxi = Math.max(maxi, prices[j] - mini);
            j++;
        }
        return maxi;
    }
}