class Solution {
    public int maxProfit(int[] prices) {
        int maxi = prices[prices.length-1];
        int maxiP = 0;
        for(int i=prices.length-1; i>=0; i--)
        {
            maxi = Math.max(maxi, prices[i]);
            maxiP = Math.max(maxiP, maxi-prices[i]);
        }
        return maxiP;
    }
}